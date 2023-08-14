package com.springboot.crud.entities;

import com.springboot.config.audit.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User extends Auditable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private Long mobile;
	private String address;
	
	@Version
	private long version;
	
}
