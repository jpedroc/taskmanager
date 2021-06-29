package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.Task;
import com.basis.colatina.taskmanager.service.dto.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DocumentMapper.class, CommentMapper.class})
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {
    @Override
    @Mapping(source = "ownerId", target = "owner.id")
    @Mapping(source = "statusId", target = "status.id")
    Task toEntity(TaskDTO taskDTO);

    @Override
    @InheritInverseConfiguration
    TaskDTO toDto(Task task);
}
