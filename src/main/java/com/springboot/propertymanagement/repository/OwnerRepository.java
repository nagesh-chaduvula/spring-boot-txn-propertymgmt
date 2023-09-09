package com.springboot.propertymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.propertymanagement.entity.OwnerEntity;


public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
	
   	Optional<OwnerEntity> findByOwnerEmailAndPassword(String email, String password);
   	
   	Optional<OwnerEntity> findByOwnerEmail(String email);

}
