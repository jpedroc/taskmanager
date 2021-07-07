package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.elastic.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elasticsearch/reindex")
@RequiredArgsConstructor
public class ElasticsearchResource {

    private final ElasticsearchService elasticsearchService;

    @GetMapping
    public ResponseEntity<String> reindex() {
        this.elasticsearchService.reindex();
        return ResponseEntity.ok().body("Reindexing all elasticsearch...");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindexEntity(@PathVariable String entity) {
        this.elasticsearchService.reindexEntity(entity);
        return ResponseEntity.ok().body("Reindexing entity elasticsearch...");
    }

}
