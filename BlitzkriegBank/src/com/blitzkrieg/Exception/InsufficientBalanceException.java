package com.blitzkrieg.Exception;

public class InsufficientBalanceException extends Exception {
private int balance;
public InsufficientBalanceException(int balance) {
	super();
	this.balance=balance;
}
@Override
public String toString() {
	return "InsufficientBalanceException [balance=" + balance + "]";
}
}
