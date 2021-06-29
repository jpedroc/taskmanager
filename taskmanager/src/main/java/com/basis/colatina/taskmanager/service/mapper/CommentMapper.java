package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.Comment;
import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.service.dto.CommentDTO;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {

    @Override
    @Mapping(source = "taskId", target = "task.id")
    Comment toEntity(CommentDTO commentDTO);

    @Override
    @InheritInverseConfiguration
    CommentDTO toDto(Comment comment);
}
