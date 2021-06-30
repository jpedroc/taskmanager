package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.DocumentService;
import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents/")
@RequiredArgsConstructor
public class DocumentResource {

    private final DocumentService documentService;

    @PostMapping
    ResponseEntity<String> create(@RequestBody DocumentDTO documentDTO) {
        DocumentDTO dto = documentService.save(documentDTO);
        return ResponseEntity.ok(dto.getFile());
    }
}
