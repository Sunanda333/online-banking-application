package com.blitzkrieg.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Customer {
		private int customerID;
		private String customerName;
		private int custType;
		private boolean isBlocked;
		public Date dob;
		private boolean isOnlineBanking;
		
//		public List<CustomerKYC> customerKYCs;
//		public List<ContactInfo> contactInfos;
//		public CustomerAddress customerAddress;
//		public OnlineBankingCredentials credential;
//		public List<Account> accounts;
		

		public Customer(int customerID, String customerName, int custType, boolean isBlocked,Date dob, boolean isOnlineBanking) {
			super();
			this.customerID = customerID;
			this.customerName = customerName;
			this.custType = custType;
			this.isBlocked = isBlocked;
			this.isOnlineBanking = isOnlineBanking;
			this.dob=dob;
			
		}
		
		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}
		public int getCustomerID() {
			return customerID;
		}
		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public int getCustType() {
			return custType;
		}
		public void setCustType(int custType) {
			this.custType = custType;
		}
		public boolean isBlocked() {
			return isBlocked;
		}
		public void setBlocked(boolean isBlocked) {
			this.isBlocked = isBlocked;
		}
		public boolean isOnlineBanking() {
			return isOnlineBanking;
		}
		public void setOnlineBanking(boolean isOnlineBanking) {
			this.isOnlineBanking = isOnlineBanking;
		}

		@Override
		public String toString() {
			return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", custType=" + custType
					+ ", isBlocked=" + isBlocked + ", dob=" + dob + ", isOnlineBanking=" + isOnlineBanking + "]";
		}

		
		
	
		
	}

