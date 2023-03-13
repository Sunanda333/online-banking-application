package com.blitzkrieg.model;

public class Employee {
		private int employeeID;
		private String name;
		private String password;
		public Employee() {
		}
		public Employee(int employeeID, String name, String password) {
			super();
			this.employeeID = employeeID;
			this.name = name;
			this.password = password;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "Employee [employeeID=" + employeeID + ", name=" + name + ", password=" + password + "]";
		}
		
	}


