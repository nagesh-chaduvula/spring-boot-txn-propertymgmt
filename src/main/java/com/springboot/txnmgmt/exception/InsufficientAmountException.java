package com.springboot.txnmgmt.exception;

public class InsufficientAmountException extends RuntimeException {

	public InsufficientAmountException(String msg) {
		super(msg);
	}
}
