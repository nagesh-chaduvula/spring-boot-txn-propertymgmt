package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entities.ReworkClaimDetail;
import com.springboot.crud.service.ReworkClaimDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reworkClaimDetail")
public class ReworkClaimDetailController {
	
	private final ReworkClaimDetailService reworkClaimDetailService;
	
	@Value("${spring.datasource.urllll:}")
	private String url;
	
	@GetMapping("/all")
	public ResponseEntity<List<ReworkClaimDetail>> findAllReworkClaimDetail() {
		System.out.println("spring.datasource.url: -> " + url);
		List<ReworkClaimDetail> reworkClaimDetails = reworkClaimDetailService.getReworkClaimDetails();
		return new ResponseEntity<>(reworkClaimDetails, HttpStatus.OK);
	}
}
