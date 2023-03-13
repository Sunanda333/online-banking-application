package com.blitzkrieg.service;
import com.blitzkrieg.dao.daoimpl.CustomerDAOImpl;
import com.blitzkrieg.model.OnlineBankingCredentials;
import com.blitzkrieg.utils.AppUtils;

public class LoginService {
	//OnlineBankingCredentials creds;
	CustomerDAOImpl customerDaoImpl;
	public LoginService() {
		customerDaoImpl = new CustomerDAOImpl();
	}
	public int validate(String userName, String password) {
		AppUtils apputil = new AppUtils();
		if(apputil.isValidUsername(userName)) {
			return customerDaoImpl.validate(userName, password);
		}
		else
			return -1;
	}

}
