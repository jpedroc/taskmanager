package com.basis.colatina.taskmanager.repository.elastic;

import com.basis.colatina.taskmanager.domain.elastic.OwnerDocument;

public interface OwnerSearchRepository extends ElasticEntity<OwnerDocument, Integer> {

    @Override
    default Class<OwnerDocument> getEntityClass() {
        return OwnerDocument.class;
    }
}
