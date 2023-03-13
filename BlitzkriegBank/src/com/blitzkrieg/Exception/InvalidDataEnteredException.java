package com.blitzkrieg.Exception;

public class InvalidDataEnteredException extends Exception{
private String data;
public InvalidDataEnteredException(String data) {
	super();
	this.data=data;
}
@Override
public String toString() {
	return "InvalidDataEnteredException [Data=" + data + "]";
}

}
