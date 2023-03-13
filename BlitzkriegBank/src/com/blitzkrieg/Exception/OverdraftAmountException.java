package com.blitzkrieg.Exception;

public class OverdraftAmountException extends Exception {
private int amount;
public OverdraftAmountException(int amount) {
	super();
	this.amount=amount;
}
@Override
public String toString() {
	return "OverdraftAmountException [amount=" + amount + "]";
}

}
