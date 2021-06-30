package com.basis.colatina.documentmanager.resource;

import com.basis.colatina.documentmanager.service.DocumentService;
import com.basis.colatina.documentmanager.service.dto.DocumentDTO;
import jdk.nashorn.internal.runtime.ECMAException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
@Slf4j
public class DocumentResource {

    private final DocumentService documentService;

    @GetMapping("/{uuid}")
    public ResponseEntity<String> getDocumets(@PathVariable("uuid") String uuid) {
        String file = documentService.getFile(uuid);
        log.info("Documento recuperado com sucesso: {}", uuid);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DocumentDTO documentDTO) throws IOException {
        documentService.uploadFile(documentDTO);
        log.info("Documento criado com sucesso: {}", documentDTO.getUuid());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable("uuid") String uuid) {
        documentService.delete(uuid);
        log.info("Documento removido com sucesso: {}", uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
