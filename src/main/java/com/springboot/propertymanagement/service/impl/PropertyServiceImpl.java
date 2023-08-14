package com.springboot.propertymanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.propertymanagement.entity.PropertyEntity;
import com.springboot.propertymanagement.mapper.PropertyMapper;
import com.springboot.propertymanagement.model.dto.PropertyDto;
import com.springboot.propertymanagement.repository.PropertyRepository;
import com.springboot.propertymanagement.service.PropertyService;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public PropertyDto saveProperty(PropertyDto propertyDto) {

		PropertyEntity propertyEntity = propertyMapper.mapToPropertyEntity(propertyDto);
		propertyEntity = propertyRepository.save(propertyEntity);
		propertyDto = propertyMapper.mapToPropertyDto(propertyEntity);

		return propertyDto;
	}

	@Override
	public List<PropertyDto> getAllProperties() {
		System.out.println("start... getAllProperties()");

		List<PropertyEntity> propertiyEntities = propertyRepository.findAll();

		return propertiyEntities.stream().map(propertyEntity -> {
			return propertyMapper.mapToPropertyDto(propertyEntity);
		}).toList();

	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public PropertyDto updateProperty(PropertyDto propertyDto) throws Exception {
		System.out.println("start... updateProperty()");
		Optional<PropertyEntity> optionalPropEntity = propertyRepository.findById(propertyDto.getId());
		
		if (optionalPropEntity.isPresent()) {
			try {
				System.out.println("Entering into sleep");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Came out from sleep");
			PropertyEntity propertyEntity = propertyMapper.mapToPropertyEntity(propertyDto);
			propertyEntity = propertyRepository.save(propertyEntity);
			final PropertyDto propertyDto1 = propertyMapper.mapToPropertyDto(propertyEntity);
			
			Thread t = new Thread(() -> {
				PropertyDto updatePartialProperty = updatePartialProperty(propertyDto1);
				System.out.println("Inside Thread --> " + updatePartialProperty.getTitle());
			});
			t.start();
			
			if (true) {
				throw new Exception("rollbackFor...");
			}
			System.out.println(propertyDto.getTitle());
			return propertyDto;
			
		} else		
			return null;
	}

	@Override
	@Async
	@Transactional(propagation = Propagation.MANDATORY)
	public PropertyDto updatePartialProperty(PropertyDto propertyDto) {
		System.out.println("start... updatePartialProperty()");
		Optional<PropertyEntity> optionalPropEntity = propertyRepository.findById(propertyDto.getId());
		
		if (optionalPropEntity.isPresent()) {
			PropertyEntity propertyEntity = optionalPropEntity.get();
			propertyMapper.mapToPartialPropertyEntity(propertyEntity, propertyDto);
			propertyEntity = propertyRepository.save(propertyEntity);
			propertyDto = propertyMapper.mapToPropertyDto(propertyEntity);
			return propertyDto;
			
		} else		
			return null;
	}

	@Override
	public void deleteProperty(Long id) {
		propertyRepository.deleteById(id);
	}

}
