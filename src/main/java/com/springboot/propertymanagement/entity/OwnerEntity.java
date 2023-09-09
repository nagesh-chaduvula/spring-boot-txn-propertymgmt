package com.springboot.propertymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_owner")

@Getter
@Setter
public class OwnerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_owner_seq_generator")
	@SequenceGenerator(name = "tb_owner_seq_generator", sequenceName = "tb_owner_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	private String ownerName;
	
	@Column(name = "owner_email", nullable = false)
	private String ownerEmail;
	private String phone;
	private String password;
}
