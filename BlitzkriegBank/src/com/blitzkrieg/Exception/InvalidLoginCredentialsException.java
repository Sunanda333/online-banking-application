package com.blitzkrieg.Exception;

public class InvalidLoginCredentialsException extends Exception {
private String Username;
private String password;

public InvalidLoginCredentialsException() {
	super();
}

@Override
public String toString() {
	return "InvalidLoginCredentialsException";
}
}
