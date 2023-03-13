package com.blitzkrieg.model;

public class ContactInfo {
	private int contactID;
	private String contactInfo;
	private int contactType;
	private boolean isPrimary;
	
	public ContactInfo(int contactID,String contactInfo, int contactType, boolean isPrimary) {
		super();
		this.contactInfo = contactInfo;
		this.contactType = contactType;
		this.isPrimary = isPrimary;
		this.contactID = contactID;
	}
	public ContactInfo() {
		// TODO Auto-generated constructor stub
	}
	public int getcontactID() {
		return contactID;
	}
	public void setcontactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public int getContactType() {
		return contactType;
	}
	public void setContactType(int contactType) {
		this.contactType = contactType;
	}
	public boolean getisPrimary() {
		return isPrimary;
	}
	public void setisPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "ContactInfo [contactID=" + contactID + ", contactInfo=" + contactInfo + ", contactType=" + contactType
				+ ", isPrimary=" + isPrimary + "]";
	}
	
}
