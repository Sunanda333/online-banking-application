package com.blitzkrieg.model;

public class AccountType {
	private int accountType;
	private float minimumBalance;
	private float overdraftAmountLimit;
	private String typeName;
	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountType(int accountType, float minimumBalance, float overdraftAmountLimit) {
		super();
		this.accountType = accountType;
		this.minimumBalance = minimumBalance;
		this.overdraftAmountLimit = overdraftAmountLimit;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public float getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(float minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public float getOverdraftAmountLimit() {
		return overdraftAmountLimit;
	}
	public void setOverdraftAmountLimit(float overdraftAmountLimit) {
		this.overdraftAmountLimit = overdraftAmountLimit;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "AccountType [accountType=" + accountType + ", minimumBalance=" + minimumBalance
				+ ", overdraftAmountLimit=" + overdraftAmountLimit + "]";
	}
	
}
