package com.blitzkrieg.model;

import java.util.List;

public class OnlineBankingCredentials {
	private String userName;
	private String password;
	
	public List<LoginInfo> loginInfos; 
	
	public OnlineBankingCredentials() {
	}
	
	public OnlineBankingCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "OnlineBankingCredentials [userName=" + userName + ", password=" + password + "]";
	}
	
}
