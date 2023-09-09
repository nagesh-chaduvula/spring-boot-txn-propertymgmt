package com.springboot.propertymanagement.service;

import com.springboot.propertymanagement.model.dto.OwnerDto;

public interface OwnerService {

	OwnerDto register(OwnerDto ownerDto);
	
	OwnerDto login(String email, String password);
}
