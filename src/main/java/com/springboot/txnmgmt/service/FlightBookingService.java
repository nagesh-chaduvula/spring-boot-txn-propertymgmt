package com.springboot.txnmgmt.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.txnmgmt.dto.FlightBookingAcknowledgement;
import com.springboot.txnmgmt.dto.FlightBookingRequest;
import com.springboot.txnmgmt.entity.PassengerEntity;
import com.springboot.txnmgmt.entity.PaymentEntity;
import com.springboot.txnmgmt.repository.PassengerRepository;
import com.springboot.txnmgmt.repository.PaymentRepository;
import com.springboot.txnmgmt.util.PaymentUtil;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerEntity passengerEntity = request.getPassengerEntity();
		passengerEntity = passengerRepository.save(passengerEntity);
		
		PaymentEntity paymentEntity = request.getPaymentEntity();
		PaymentUtil.validateCreditLimit(paymentEntity.getAccountNo(), passengerEntity.getFare());
		
		paymentEntity.setPassengerId(passengerEntity.getId());
		paymentEntity.setAmount(passengerEntity.getFare());
		
		paymentRepository.save(paymentEntity);
		
		return new FlightBookingAcknowledgement("SUCCESS", passengerEntity.getFare(), UUID.randomUUID().toString().split("-")[0], passengerEntity);
	}
	
}
