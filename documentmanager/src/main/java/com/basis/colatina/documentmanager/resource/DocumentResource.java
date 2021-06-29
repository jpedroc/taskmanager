package com.basis.colatina.documentmanager.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentResource {

    @GetMapping()
    public ResponseEntity<String> getDocumets() {
        return ResponseEntity.ok("Documents");
    }
}
