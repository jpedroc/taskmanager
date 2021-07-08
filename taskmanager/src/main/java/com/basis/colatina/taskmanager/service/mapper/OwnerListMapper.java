package com.basis.colatina.taskmanager.service.mapper;

import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.domain.elastic.OwnerDocument;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import com.basis.colatina.taskmanager.service.dto.listing.OwnerListDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerListMapper extends EntityMapper<OwnerListDTO, OwnerDocument> {
}
