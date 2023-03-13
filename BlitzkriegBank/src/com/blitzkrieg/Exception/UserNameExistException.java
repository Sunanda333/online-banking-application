package com.blitzkrieg.Exception;

public class UserNameExistException extends Exception {

	public UserNameExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNameExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNameExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNameExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserNameExistException []";
	}

	
}
