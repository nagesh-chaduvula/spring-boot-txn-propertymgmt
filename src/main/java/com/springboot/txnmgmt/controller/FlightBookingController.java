package com.springboot.txnmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.txnmgmt.dto.FlightBookingAcknowledgement;
import com.springboot.txnmgmt.dto.FlightBookingRequest;
import com.springboot.txnmgmt.service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
	}
	
	
}
