package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.Document;
import com.basis.colatina.taskmanager.service.dto.DocumentDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper extends EntityMapper<DocumentDTO, Document> {

    @Override
    @Mapping(source = "taskId", target = "task.id")
    Document toEntity(DocumentDTO documentDTO);

    @Override
    @InheritInverseConfiguration
    DocumentDTO toDto(Document document);
}
