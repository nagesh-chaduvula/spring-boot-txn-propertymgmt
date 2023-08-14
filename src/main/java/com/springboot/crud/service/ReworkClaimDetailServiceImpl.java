package com.springboot.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.crud.entities.ReworkClaimDetail;
import com.springboot.crud.repository.ReworkClaimDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReworkClaimDetailServiceImpl implements ReworkClaimDetailService {

	private final ReworkClaimDetailRepository reworkClaimDetailRepository;
	
	@Override
	public List<ReworkClaimDetail> getReworkClaimDetails() {
		return reworkClaimDetailRepository.findAll();
	}

}
