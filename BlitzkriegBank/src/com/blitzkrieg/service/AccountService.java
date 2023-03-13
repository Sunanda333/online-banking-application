package com.blitzkrieg.service;

import java.sql.SQLException;
import java.util.List;

import com.blitzkrieg.dao.AccountDAO;
import com.blitzkrieg.dao.daoimpl.AccountDAOImpl;
import com.blitzkrieg.model.Account;

public class AccountService {
	
	private AccountDAOImpl accountDao;
	public AccountService() {
		accountDao = new AccountDAOImpl();
	}
	
	public void openAccount(int customerID, int accountType, Account account) throws SQLException {
		accountDao.addAccount(customerID, accountType, account);
	}

	public Account getAccount(long accountID) {
		return accountDao.getAccount(accountID);
	}

	public List<Account> getAllAccountsofCustomer(int customerID) {
		return accountDao.getAllAccountsofCustomer(customerID);
	}

}