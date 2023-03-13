package com.blitzkrieg.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.blitzkrieg.Exception.OnlineBankingExistsException;
import com.blitzkrieg.Exception.UserNameExistException;
import com.blitzkrieg.dao.daoimpl.AccountDAOImpl;
import com.blitzkrieg.dao.daoimpl.CustomerDAOImpl;
import com.blitzkrieg.model.ContactInfo;
import com.blitzkrieg.model.Customer;
import com.blitzkrieg.model.CustomerAddress;
import com.blitzkrieg.model.CustomerKYC;
import com.blitzkrieg.model.OnlineBankingCredentials;
import com.blitzkrieg.utils.AppUtils;
import com.blitzkrieg.utils.EncryptDecryptString;

public class CustomerService {

	private CustomerDAOImpl customerDAO;

	public CustomerService() {
		customerDAO = new CustomerDAOImpl();
	}

	public boolean validateCustomer(int customerId, String nameOfAccount) throws OnlineBankingExistsException {
		Customer customer = customerDAO.getCustomer(customerId);
		if (customer == null) {
			return false;
		} else if (!customer.isOnlineBanking()) {
			return customer.getCustomerName().equals(nameOfAccount);
		} else {
			throw new OnlineBankingExistsException();
		}
	}

	public boolean blockCustomer(int CustomerId) {
		if(customerDAO.blockCustomer(CustomerId))
		return true;
		return false;
		
	}
	
	public void addCustomer(Customer customer, CustomerAddress address, CustomerKYC customerKYC) {
		customerDAO.addCustomer(customer);
		customerDAO.addCustomerAddress(customer.getCustomerID(), address);
		customerDAO.addCutomerKYC(customer.getCustomerID(), customerKYC);
	}
	
	public void addOnlineBankingCredentials(String userName, String password, int customerID) throws UserNameExistException {
		
		//check if username is unique
		if(customerDAO.validate(userName, password)!=-1) {//wrong needs to be fixed
			throw new UserNameExistException();
		}
		OnlineBankingCredentials cred = new OnlineBankingCredentials(userName,EncryptDecryptString.encrypt(password));
		customerDAO.addOnlineBankingCredentials(cred, customerID);
		
	}
	
	public boolean removeCustomerWithoutAccount(int customerID) throws SQLException {
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		if (accountDAO.isCreated(customerID)) {
			return false;
		} else {
			customerDAO.deleteCustomer(customerID);
			return true;
		}

	}

	public Customer getDetails(int CustomerID) {
		return customerDAO.getCustomer(CustomerID);
	}

	public void setDetails(Customer customer) {
		// CustomerDaoImpl.updateCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	public boolean validateInfo(int customerId, String panNumber, String email, String phoneNumber, String date) {
		HashMap<String, CustomerKYC> ck = customerDAO.getCustomerKYC(customerId);
		HashMap<String, ContactInfo> ci = customerDAO.getContactInfo(customerId);
		Customer c = customerDAO.getCustomer(customerId);
		int count = 0;
		if (ck.containsKey(panNumber))
			count++;

		if (ci.containsKey(phoneNumber))
			count++;

		if (ci.containsKey(email))
			count++;

		if (c.dob.toString().equals(date))
			count++;

		if (count >= 2)
			return true;
		return false;
	//	return true;
	}

	public CustomerAddress getCustomerAddress(int customerId) {
		return customerDAO.getCustomerAddress(customerId);
	}

	public List<CustomerKYC> getCustomerKYCList(int customerId) {
		return customerDAO.getCustomerKYCList(customerId);
	}

}
