package com.blitzkrieg.model;

import java.util.Date;

public class LoginInfo {
	private String sessionID;
	private Date sessionTime;
	private Date loginTime;
	private String ipAddress;
	public LoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginInfo(String sessionID, Date sessionTime, Date loginTime, String ipAddress) {
		super();
		this.sessionID = sessionID;
		this.sessionTime = sessionTime;
		this.loginTime = loginTime;
		this.ipAddress = ipAddress;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public Date getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Override
	public String toString() {
		return "LoginInfo [sessionID=" + sessionID + ", sessionTime=" + sessionTime + ", loginTime=" + loginTime
				+ ", ipAddress=" + ipAddress + "]";
	}
	
}
