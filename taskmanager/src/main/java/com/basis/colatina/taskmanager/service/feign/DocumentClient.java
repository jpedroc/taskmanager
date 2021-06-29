package com.basis.colatina.taskmanager.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "documents", url = "${application.feign.documents}")
public interface DocumentClient {

    @GetMapping("/api/documents")
    String getDocuments();
}
