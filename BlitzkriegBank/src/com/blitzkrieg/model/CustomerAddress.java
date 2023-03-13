package com.blitzkrieg.model;

public class CustomerAddress {
	private String buildingName;
	private String city;
	private int pincode;
	private String state;
	private String country;
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerAddress(String buildingName, String city, int pincode, String state, String country) {
		super();
		this.buildingName = buildingName;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "CustomerAddress [buildingName=" + buildingName + ", city=" + city + ", pincode=" + pincode + ", state="
				+ state + ", country=" + country + "]";
	}
	
}
