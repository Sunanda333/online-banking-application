package com.blitzkrieg.model;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
	private int transactionID;
	private Timestamp timeStamp;
	private float amount;
	private int transactionTypeID;
	private String remarks;
	private long accountID;
	public Transaction() {
	}

	public Transaction(int transactionID, Timestamp timeStamp, float amount, int transactionTypeID, String remarks,long accountID) {
		super();
		this.transactionID = transactionID;
		this.timeStamp = timeStamp;
		this.amount = amount;
		this.transactionTypeID = transactionTypeID;
		this.remarks = remarks;
		this.accountID = accountID;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int gettransactionTypeID() {
		return transactionTypeID;
	}

	public void settransactionTypeID(int transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", timeStamp=" + timeStamp + ", amount=" + amount
				+ ", transactionTypeID=" + transactionTypeID + ", remarks=" + remarks + "]";
	}
	
}
