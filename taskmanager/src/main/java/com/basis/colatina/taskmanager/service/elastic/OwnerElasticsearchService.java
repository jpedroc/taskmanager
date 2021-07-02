package com.basis.colatina.taskmanager.service.elastic;

import com.basis.colatina.taskmanager.domain.elastic.OwnerDocument;
import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import com.basis.colatina.taskmanager.repository.OwnerRepository;
import com.basis.colatina.taskmanager.repository.TaskRepository;
import com.basis.colatina.taskmanager.repository.elastic.OwnerSearchRepository;
import com.basis.colatina.taskmanager.repository.elastic.TaskSearchRepository;
import com.basis.colatina.taskmanager.service.event.OwnerEvent;
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
public class OwnerElasticsearchService {

    private final OwnerRepository ownerRepository;
    private final OwnerSearchRepository ownerSearchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(OwnerEvent event) {
        log.info("Starting index from task by id: {}", event.getId());
        OwnerDocument document = ownerRepository.getDocument(event.getId());
        ownerSearchRepository.save(document);
    }

}
