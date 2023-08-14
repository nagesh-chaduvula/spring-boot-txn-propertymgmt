package com.springboot.txnmgmt.dto;

import com.springboot.txnmgmt.entity.PassengerEntity;
import com.springboot.txnmgmt.entity.PaymentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
	private PassengerEntity passengerEntity;
	private PaymentEntity paymentEntity;
}
