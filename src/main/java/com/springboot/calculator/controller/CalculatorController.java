package com.springboot.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.calculator.dto.CalculatorDto;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

	// http://localhost:65238/api/v1/calculator/mul
	@PostMapping("/mul")
	public ResponseEntity<Double> multiply(@RequestBody CalculatorDto calcDto) {
		 Double result = calcDto.getNum1() * calcDto.getNum2() * calcDto.getNum3() * calcDto.getNum4();
		 ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
		 return responseEntity;
	}
}
