package com.springboot.txnmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.txnmgmt.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {

}
