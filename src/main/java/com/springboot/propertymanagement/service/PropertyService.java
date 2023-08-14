package com.springboot.propertymanagement.service;

import java.util.List;

import com.springboot.propertymanagement.model.dto.PropertyDto;

public interface PropertyService {

	PropertyDto saveProperty(PropertyDto propertyDto);
	
	List<PropertyDto> getAllProperties();
	
	PropertyDto updateProperty(PropertyDto propertyDto) throws Exception;

	PropertyDto updatePartialProperty(PropertyDto propertyDto);
	
	void deleteProperty(Long id);
	
	
}
