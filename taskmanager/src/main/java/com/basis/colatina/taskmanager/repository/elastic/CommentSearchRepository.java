package com.basis.colatina.taskmanager.repository.elastic;


import com.basis.colatina.taskmanager.domain.elastic.CommentDocument;
import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentSearchRepository extends ElasticsearchRepository<CommentDocument, Integer> {
}
