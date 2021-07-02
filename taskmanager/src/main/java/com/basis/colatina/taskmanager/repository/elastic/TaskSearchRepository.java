package com.basis.colatina.taskmanager.repository.elastic;


import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskSearchRepository extends ElasticsearchRepository<TaskDocument, Integer> {
}
