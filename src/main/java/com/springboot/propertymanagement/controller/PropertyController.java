package com.springboot.propertymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.propertymanagement.model.dto.PropertyDto;
import com.springboot.propertymanagement.service.PropertyService;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/save")
	public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto) {
		 propertyDto = propertyService.saveProperty(propertyDto);
		 return new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PropertyDto>> getAllProperties() {
		List<PropertyDto> propertyDtos = propertyService.getAllProperties();
		return new ResponseEntity<>(propertyDtos, HttpStatus.OK) ;
	}
	
	@PutMapping("/update")
	@Transactional
	public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto) {
		 try {
			propertyDto = propertyService.updateProperty(propertyDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<>(propertyDto, HttpStatus.OK);
	}
	
	@PatchMapping("/partialUpdate")
	public ResponseEntity<PropertyDto> updatePartialProperty(@RequestBody PropertyDto propertyDto) {
		 propertyDto = propertyService.updatePartialProperty(propertyDto);
		 return new ResponseEntity<>(propertyDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteProeprty(@PathVariable Long id) {
		propertyService.deleteProperty(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
}
