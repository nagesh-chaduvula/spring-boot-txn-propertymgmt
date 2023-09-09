package com.springboot.propertymanagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedCustomExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)	// This exception thrown by spring framework.
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manvexcep) {
		List<ErrorModel> errorModelList = new ArrayList();
		List<FieldError> fieldErrors = manvexcep.getBindingResult().getFieldErrors();
		
		fieldErrors.stream().forEach(fieldError -> {
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode(fieldError.getCode());
			errorModel.setMessage(fieldError.getDefaultMessage());
			errorModelList.add(errorModel);
		});
		
		return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusinessException.class)	// This exception thrown by in our OwnerServiceImpl class
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
		System.out.println(":: handleBusinessException() - Handling BusinessException here, thrown by some where else... ::");
		return new ResponseEntity<>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
	}
	
}
