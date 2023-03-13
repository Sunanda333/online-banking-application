package com.blitzkrieg.model;

import java.util.Date;
import java.util.List;

public class Account {
	private long accountID;
	private Date openingDate;
	private float currentBalance;
	private int accountTypeID;
	public List<Transaction> transactions;
	
	public Account() {
	}
	public Account(long accountID, Date openingDate, float currentBalance,int accountTypeID ) {
		super();
		this.accountID = accountID;
		this.openingDate = openingDate;
		this.currentBalance = currentBalance;
		this.setAccountTypeID(accountTypeID);
	}
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public float getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public int getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", openingDate=" + openingDate + ", currentBalance=" + currentBalance
				+ "]";
	}
	
}
