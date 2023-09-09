package com.springboot.propertymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.propertymanagement.model.dto.OwnerDto;
import com.springboot.propertymanagement.service.OwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/register")
	public ResponseEntity<OwnerDto> register(@Valid @RequestBody OwnerDto ownerDto) {
		OwnerDto registeredOwnerDto = ownerService.register(ownerDto);
		return new ResponseEntity<>(registeredOwnerDto, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<OwnerDto> login(@RequestBody OwnerDto ownerDto) {
		ownerDto = ownerService.login(ownerDto.getOwnerEmail(), ownerDto.getPassword());
		return new ResponseEntity<>(ownerDto, HttpStatus.OK);
	}
	
}
