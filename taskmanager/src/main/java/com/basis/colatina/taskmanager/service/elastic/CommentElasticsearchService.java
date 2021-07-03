package com.basis.colatina.taskmanager.service.elastic;

import com.basis.colatina.taskmanager.domain.elastic.CommentDocument;
import com.basis.colatina.taskmanager.repository.CommentRepository;
import com.basis.colatina.taskmanager.repository.elastic.CommentSearchRepository;
import com.basis.colatina.taskmanager.service.event.CommentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentElasticsearchService {

    private final CommentRepository commentRepository;
    private final CommentSearchRepository commentSearchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(CommentEvent event) {
        log.info("Starting index from task by id: {}", event.getId());
        CommentDocument document = commentRepository.getDocument(event.getId());
        commentSearchRepository.save(document);
    }

}
