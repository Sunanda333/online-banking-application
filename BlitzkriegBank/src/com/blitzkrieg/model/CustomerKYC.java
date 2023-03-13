package com.blitzkrieg.model;
public class CustomerKYC {
	private int KYCType;
	private String KYCNo;
	public CustomerKYC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerKYC(int kYCType, String kYCNo) {
		super();
		KYCType = kYCType;
		KYCNo = kYCNo;
	}
	public int getKYCType() {
		return KYCType;
	}
	public void setKYCType(int kYCType) {
		KYCType = kYCType;
	}
	public String getKYCNo() {
		return KYCNo;
	}
	public void setKYCNo(String kYCNo) {
		KYCNo = kYCNo;
	}
	@Override
	public String toString() {
		return "CustomerKYC [KYCType=" + KYCType + ", KYCNo=" + KYCNo + "]";
	}
	
}
