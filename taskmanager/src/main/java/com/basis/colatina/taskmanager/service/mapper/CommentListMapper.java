package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.elastic.CommentDocument;
import com.basis.colatina.taskmanager.service.dto.listing.CommentListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentListMapper extends EntityMapper<CommentListDTO, CommentDocument> {

}
