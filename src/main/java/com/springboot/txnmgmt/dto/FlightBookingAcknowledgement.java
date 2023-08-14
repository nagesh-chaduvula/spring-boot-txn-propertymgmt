package com.springboot.txnmgmt.dto;

import com.springboot.txnmgmt.entity.PassengerEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAcknowledgement {
	private String status;
	private double totalFare;
	private String pnr;
	private PassengerEntity passengerEntity;
}
