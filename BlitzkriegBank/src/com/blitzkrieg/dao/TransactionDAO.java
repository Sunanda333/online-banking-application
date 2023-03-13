package com.blitzkrieg.dao;

import java.util.List;

import com.blitzkrieg.model.Transaction;

public interface TransactionDAO {
	public List<Transaction> getCustTransaction(long customerId);
	public Transaction getTransaction(int transactionID);
	public void addTransaction(Transaction transaction);
	public List<Transaction> getRecentTransaction(long accountID);
}
