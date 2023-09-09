package com.springboot.propertymanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.springboot.propertymanagement.entity.OwnerEntity;
import com.springboot.propertymanagement.model.dto.OwnerDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OwnerMapper {
	OwnerEntity mapToOwnerEntity(OwnerDto ownerDto);
	
	@Mapping(target = "password", ignore = true)
	OwnerDto mapToOwnerDto(OwnerEntity ownerEntity);

	
	
}
