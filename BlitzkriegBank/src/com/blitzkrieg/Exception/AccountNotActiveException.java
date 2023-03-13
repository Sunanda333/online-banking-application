package com.blitzkrieg.Exception;

public class AccountNotActiveException extends Exception {
	private int acctno;
	public AccountNotActiveException(int acctno) {
		super();
		this.acctno=acctno;
		
	}
	@Override
	public String toString() {
		return "AccountNotActiveException [acctno=" + acctno + "]";
	}
}
