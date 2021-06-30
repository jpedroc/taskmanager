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
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final DocumentClient documentClient;

    public DocumentDTO save(DocumentDTO documentDTO) {
        Document document = documentMapper.toEntity(documentDTO);

        documentDTO.setUuid(UUID.randomUUID().toString());
        documentClient.createDocument(documentDTO);
        document.setFile(documentDTO.getUuid());

        documentRepository.save(document);

        return documentMapper.toDto(document);
    }

    public DocumentDTO findOne(Integer id) {
        Document document = getOne(id);
        document.setFile(documentClient.getDocument(document.getFile()));

        return documentMapper.toDto(document);
    }

    public void delete(Integer id){
        Document document = getOne(id);

        documentRepository.delete(document);
        documentClient.deleteDocument(document.getFile());
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
