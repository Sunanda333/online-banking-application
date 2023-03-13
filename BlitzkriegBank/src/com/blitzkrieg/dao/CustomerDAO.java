package com.blitzkrieg.dao;

import java.util.List;

import com.blitzkrieg.model.Customer;

public interface CustomerDAO {
	public Customer getCustomer(long customerID);
	public List<Customer> getAllCustomer();
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Boolean valdiate(String userName, String password);
}
