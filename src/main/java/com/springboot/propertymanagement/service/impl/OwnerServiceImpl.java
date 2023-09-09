package com.springboot.propertymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.propertymanagement.entity.OwnerEntity;
import com.springboot.propertymanagement.exception.BusinessException;
import com.springboot.propertymanagement.exception.ErrorModel;
import com.springboot.propertymanagement.mapper.OwnerMapper;
import com.springboot.propertymanagement.model.dto.OwnerDto;
import com.springboot.propertymanagement.repository.OwnerRepository;
import com.springboot.propertymanagement.service.OwnerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

	private final OwnerMapper ownerMapper;
	
	private final OwnerRepository ownerRepository;
	
	List<ErrorModel> errorModelList = new ArrayList();
	
	@Override
	public OwnerDto register(OwnerDto ownerDto) {
		Optional<OwnerEntity> ownerEntityOptional = ownerRepository.findByOwnerEmail(ownerDto.getOwnerEmail());
		if (ownerEntityOptional.isPresent()) {
			
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("EMAIL_ALREADY_EXIST");
			errorModel.setMessage("The Email which user trying to regiser is already exist!!!");
			
			errorModelList = List.of(errorModel);			
			throw new BusinessException(errorModelList);
		}
		OwnerEntity userEntity = ownerMapper.mapToOwnerEntity(ownerDto);
		userEntity = ownerRepository.save(userEntity);
		ownerDto = ownerMapper.mapToOwnerDto(userEntity);
		return ownerDto;
	}

	@Override
	public OwnerDto login(String email, String password) {
		OwnerDto ownerDto = null;
		Optional<OwnerEntity> ownerEntityOptional = ownerRepository.findByOwnerEmailAndPassword(email, password);
		
		if (ownerEntityOptional.isPresent()) {
			OwnerEntity ownerEntity = ownerEntityOptional.get();
			ownerDto = ownerMapper.mapToOwnerDto(ownerEntity);
		
		} else {
			
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("INVALID_LOGIN");
			errorModel.setMessage("User entered incorrect email or password while login...");
			
			errorModelList = List.of(errorModel);			
			throw new BusinessException(errorModelList);
		}
		return ownerDto;
	}

}
