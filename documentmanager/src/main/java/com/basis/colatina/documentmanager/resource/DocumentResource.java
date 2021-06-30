package com.basis.colatina.documentmanager.resource;

import com.basis.colatina.documentmanager.service.DocumentService;
import com.basis.colatina.documentmanager.service.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentResource {

    private final DocumentService documentService;

    @GetMapping()
    public ResponseEntity<String> getDocumets() {
        return ResponseEntity.ok("Documents");
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody DocumentDTO documentDTO) throws IOException {
        String keyID = documentService.uploadFile(documentDTO);
        return ResponseEntity.ok(keyID);
    }
}
