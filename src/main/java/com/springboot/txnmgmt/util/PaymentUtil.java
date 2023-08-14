package com.springboot.txnmgmt.util;

import java.util.HashMap;
import java.util.Map;

import com.springboot.txnmgmt.exception.InsufficientAmountException;

public class PaymentUtil {

	private PaymentUtil() {}
	
	private static Map<String, Double> paymentMap = new HashMap<>();
	
	static {
		paymentMap.put("acc1", 1200.00);
		paymentMap.put("acc2", 1000.00);
		paymentMap.put("acc3", 5000.00);
		paymentMap.put("acc4", 8000.00);
	}
	
	public static boolean validateCreditLimit(String accNo, double payAmount) {
		if (payAmount > paymentMap.get(accNo)) {
			throw new InsufficientAmountException("Insufficient Amount!...");
		} else {
			return true;
		}
	}
	
}
