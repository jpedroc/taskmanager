package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.service.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    public TaskDTO save(TaskDTO taskDTO) {
        return null;
    }

    public TaskDTO findOne(Integer id) {
        return null;
    }

    public void delete(Integer id) {}

}
