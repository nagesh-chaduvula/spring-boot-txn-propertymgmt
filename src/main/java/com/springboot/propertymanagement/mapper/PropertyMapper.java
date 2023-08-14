package com.springboot.propertymanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.springboot.propertymanagement.entity.PropertyEntity;
import com.springboot.propertymanagement.model.dto.PropertyDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PropertyMapper {
	PropertyEntity mapToPropertyEntity(PropertyDto propertyDto);
	
	PropertyDto mapToPropertyDto(PropertyEntity propertyEntity);

	void mapToPartialPropertyEntity(@MappingTarget PropertyEntity propertyEntity, PropertyDto propertyDto);
	
	
}
