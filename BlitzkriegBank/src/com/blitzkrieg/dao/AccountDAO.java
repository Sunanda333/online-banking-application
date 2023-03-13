package com.blitzkrieg.dao;

import com.blitzkrieg.model.Account;

public interface AccountDAO {
	public void addAccount(Account account);
	public Account getAccount(long accountId);
}
