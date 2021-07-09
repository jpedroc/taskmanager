package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import com.basis.colatina.taskmanager.service.dto.listing.TaskListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskListMapper extends EntityMapper<TaskListDTO, TaskDocument> {
}
