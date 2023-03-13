package com.blitzkrieg.Exception;

public class AccountNotFoundException extends Exception {
private int acctno;
public AccountNotFoundException(int acctno) {
	super();
	this.acctno=acctno;
	
}
@Override
public String toString() {
	return "AccountNotFoundException [acctno=" + acctno + "]";
}

}
