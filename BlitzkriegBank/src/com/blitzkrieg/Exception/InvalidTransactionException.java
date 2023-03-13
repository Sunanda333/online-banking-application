package com.blitzkrieg.Exception;

public class InvalidTransactionException extends Exception{
public InvalidTransactionException() {
	super();
}

@Override
public String toString() {
	return "InvalidTransactionException []";
}

}
