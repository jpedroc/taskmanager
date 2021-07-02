package com.basis.colatina.taskmanager.service.elastic;

import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import com.basis.colatina.taskmanager.repository.TaskRepository;
import com.basis.colatina.taskmanager.repository.elastic.TaskSearchRepository;
import com.basis.colatina.taskmanager.service.event.TaskEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskElasticsearchService {

    private final TaskRepository taskRepository;
    private final TaskSearchRepository taskSearchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(TaskEvent event) {
        log.info("Starting index from task by id: {}", event.getId());
        TaskDocument document = taskRepository.getDocument(event.getId());
        taskSearchRepository.save(document);
    }

}
