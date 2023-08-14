package com.springboot.txnmgmt.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String source;
	private String destination;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date travelDate;
	private String pickupTime;
	private String arrivalTime;
	private Double fare;
}
