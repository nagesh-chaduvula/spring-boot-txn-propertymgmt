package com.springboot.crud.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tb_product", 
		uniqueConstraints = { @UniqueConstraint(columnNames = { "stock_keeping_unit", "name" }) }
)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "prod_generator", sequenceName = "prod_seq_name", allocationSize = 1) // optional
	private Long id;

	@Column(name = "stock_keeping_unit")
	private String sku;

	@Column(nullable = false)
	private String name;

	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpdated;
}
