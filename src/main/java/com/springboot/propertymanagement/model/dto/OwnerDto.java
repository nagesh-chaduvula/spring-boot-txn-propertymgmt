package com.springboot.propertymanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDto {
	private Long id;
	private String ownerName;
	
	@NotNull(message = "Owner Email is mandatory!")
	@NotEmpty(message = "Owner Email cannot be empty!")
	private String ownerEmail;
	private String phone;
	
	@NotNull(message = "Password cannot be null")
	@NotEmpty(message = "Password cannot be empty")
	private String password;
}
