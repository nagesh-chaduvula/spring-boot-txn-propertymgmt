package com.springboot.propertymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_property")

@Getter
@Setter
public class PropertyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	private String description;
	private String ownerName;
	
	@Column(name = "owner_email", nullable = false)
	private String ownerEmail;
	private Double price;
	private String address;
}
