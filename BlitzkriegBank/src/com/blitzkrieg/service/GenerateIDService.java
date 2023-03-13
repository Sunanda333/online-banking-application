package com.blitzkrieg.service;

import java.math.BigInteger;
import java.util.UUID;

public class GenerateIDService {
	private static int accSeq = 0;
	private static long baseAccountNumber = 312100000000L;

	public static int generateCustomerID() {
		String lUUID = String.format("%05d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		int customerID = Integer.parseInt(lUUID.substring(0, 8));
		return customerID;
	}

	public static long generateAccountID() {
		accSeq++;
		return baseAccountNumber + accSeq;
	}

	public static long generateTransactionID() {
		String lUUID = String.format("%05d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		long transactionID = Long.parseLong(lUUID.substring(0, 12));
		return transactionID;
	}
}
