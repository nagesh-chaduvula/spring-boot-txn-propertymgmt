package com.springboot.txnmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.txnmgmt.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

}
