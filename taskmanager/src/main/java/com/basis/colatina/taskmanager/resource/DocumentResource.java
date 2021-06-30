package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.DocumentService;
import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<DocumentDTO> create(@RequestBody DocumentDTO documentDTO) {
        DocumentDTO dto = documentService.save(documentDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<DocumentDTO> findById(@PathVariable("id") Integer id) {
        DocumentDTO dto = documentService.findOne(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        documentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
