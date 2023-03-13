package com.blitzkrieg.Exception;

public class CustomerIdNotFoundException extends Exception {

	private int id;

	public CustomerIdNotFoundException(int id) {
		super();
		this.id=id;
		
	}

	@Override
	public String toString() {
		return "CustomerIdNotFoundException [id=" + id + "]";
	}
	
}
