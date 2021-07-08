package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.domain.Task;
import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import com.basis.colatina.taskmanager.repository.TaskRepository;
import com.basis.colatina.taskmanager.repository.elastic.TaskSearchRepository;
import com.basis.colatina.taskmanager.service.dto.TaskDTO;
import com.basis.colatina.taskmanager.service.dto.listing.TaskListDTO;
import com.basis.colatina.taskmanager.service.event.TaskEvent;
import com.basis.colatina.taskmanager.service.exception.BadRequestAlertException;
import com.basis.colatina.taskmanager.service.filter.TaskFilter;
import com.basis.colatina.taskmanager.service.mapper.TaskListMapper;
import com.basis.colatina.taskmanager.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskListMapper taskListMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final TaskSearchRepository taskSearchRepository;

    public TaskDTO save(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);

        if(task.getExpectedStartDate().isAfter(task.getExpectedEndDate())) {
            throw new BadRequestAlertException("Invalid expected date! Expected start date cannot be after the expected end date.");
        }

        if(Objects.nonNull(task.getStartDate()) && Objects.nonNull(task.getEndDate()) && task.getStartDate().isAfter(task.getEndDate())) {
            throw new BadRequestAlertException("Invalid expected date! Start date cannot be after the end date.");
        }

        taskRepository.save(task);
        this.applicationEventPublisher.publishEvent(new TaskEvent(task.getId()));
        return taskMapper.toDto(task);
    }

    public TaskDTO findOne(Integer id) {
        return taskMapper.toDto(getOne(id));
    }

    public void delete(Integer id) {
        Task task = getOne(id);
        taskRepository.delete(task);
    }

    private Task getOne(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new BadRequestAlertException("Task not found"));
    }

    public List<TaskDTO> findAll() {
        return taskMapper.toDto(taskRepository.findAll());
    }

    public Page<TaskListDTO> search(TaskFilter filter, Pageable pageable) {
        Page<TaskDocument> documents = taskSearchRepository.search(filter.getFilter(), pageable);

        return documents.map(taskListMapper::toDto);
    }
}
