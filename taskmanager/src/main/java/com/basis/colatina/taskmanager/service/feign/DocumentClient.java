package com.basis.colatina.taskmanager.service.feign;

import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "documents", url = "${application.feign.documents}")
public interface DocumentClient {

    @GetMapping("/api/documents/{uuid}")
    String getDocument(@PathVariable("uuid") String uuid);

    @PostMapping("/api/documents")
    String createDocument(DocumentDTO documentDTO);

    @DeleteMapping("/api/documents/{uuid}")
    Void deleteDocument(@PathVariable("uuid") String uuid);
}
