package com.springboot.propertymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.springboot.propertymanagement.entity.PropertyEntity;

import jakarta.persistence.LockModeType;


public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<PropertyEntity> findById(Long id);

}
