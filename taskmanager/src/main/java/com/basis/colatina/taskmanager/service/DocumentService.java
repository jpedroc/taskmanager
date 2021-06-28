package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {

    public DocumentDTO save(DocumentDTO documentDTO) {
        return null;
    }

    public DocumentDTO findOne(DocumentDTO documentDTO) {
        return null;
    }

    public void Delete(Integer id){}
}
