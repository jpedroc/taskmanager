package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends EntityMapper<OwnerDTO, Owner> {

    @Override
    @Mapping(source = "statusId", target = "status.id")
    Owner toEntity(OwnerDTO ownerDTO);

    @Override
    @InheritInverseConfiguration
    OwnerDTO toDto(Owner owner);
}
