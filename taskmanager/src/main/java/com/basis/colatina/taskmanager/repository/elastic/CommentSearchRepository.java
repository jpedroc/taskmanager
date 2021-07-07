package com.basis.colatina.taskmanager.repository.elastic;


import com.basis.colatina.taskmanager.domain.elastic.CommentDocument;

public interface CommentSearchRepository extends ElasticEntity<CommentDocument, Integer> {

    @Override
    default Class<CommentDocument> getEntityClass() {
        return CommentDocument.class;
    }
}
