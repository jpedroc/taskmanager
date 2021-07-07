package com.basis.colatina.taskmanager.repository.elastic;


import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;

public interface TaskSearchRepository extends ElasticEntity<TaskDocument, Integer> {

    @Override
    default Class<TaskDocument> getEntityClass() {
        return TaskDocument.class;
    }
}
