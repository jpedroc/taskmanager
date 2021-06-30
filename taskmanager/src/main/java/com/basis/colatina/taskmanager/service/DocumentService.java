package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.domain.Document;
import com.basis.colatina.taskmanager.repository.DocumentRepository;
import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import com.basis.colatina.taskmanager.service.exception.BadRequestAlertException;
import com.basis.colatina.taskmanager.service.feign.DocumentClient;
import com.basis.colatina.taskmanager.service.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final DocumentClient documentClient;

    public DocumentDTO save(DocumentDTO documentDTO) {
        Document document = documentMapper.toEntity(documentDTO);

        String keyDocument = documentClient.createDocument(documentDTO);

        document.setFile(keyDocument);

        documentRepository.save(document);

        return documentMapper.toDto(document);
    }

    public DocumentDTO findOne(Integer id) {
        return documentMapper.toDto(getOne(id));
    }

    public void delete(Integer id){
        Document document = getOne(id);
        documentRepository.delete(document);
    }

    private Document getOne(Integer id) {
        return documentRepository.findById(id).orElseThrow(() -> new BadRequestAlertException("Document not found"));
    }

    public List<DocumentDTO> findAll() {
        return documentMapper.toDto(documentRepository.findAll());
    }

    public List<DocumentDTO> findAllByTaskId(Integer id) {
        return documentMapper.toDto(documentRepository.findAllByTaskId(id));
    }
}
