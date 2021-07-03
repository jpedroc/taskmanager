package com.basis.colatina.taskmanager.repository.elastic;

import com.basis.colatina.taskmanager.domain.elastic.OwnerDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OwnerSearchRepository extends ElasticsearchRepository<OwnerDocument, Integer> {
}
