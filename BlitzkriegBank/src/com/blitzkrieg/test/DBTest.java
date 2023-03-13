package com.blitzkrieg.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import com.blitzkrieg.Exception.UserNameExistException;
import com.blitzkrieg.dao.daoimpl.AccountDAOImpl;
import com.blitzkrieg.dao.daoimpl.CustomerDAOImpl;
import com.blitzkrieg.dao.daoimpl.TransactionDAOIpml;
import com.blitzkrieg.model.Account;
import com.blitzkrieg.model.AccountType;
import com.blitzkrieg.model.ContactInfo;
import com.blitzkrieg.model.Customer;
import com.blitzkrieg.model.CustomerAddress;
import com.blitzkrieg.model.CustomerKYC;
import com.blitzkrieg.model.OnlineBankingCredentials;
import com.blitzkrieg.model.Transaction;
import com.blitzkrieg.service.CustomerService;
public class DBTest {

	public static void main(String[] args) throws SQLException, UserNameExistException {
		
    	CustomerDAOImpl cdao = new CustomerDAOImpl();
		AccountDAOImpl adao = new AccountDAOImpl();
		TransactionDAOIpml tdao = new TransactionDAOIpml();
		
//		cdao.deleteCustomer(12345991);
//		cdao.deleteCustomer(12345678);
		int customerID=12345991;
		String customerName="ak";
		int custType=01;
		boolean isBlocked=false;
	    Date dob=new Date(custType);
	    String str=dob.toString();
		boolean isOnlineBanking=false;
		Date date= new Date(7867563);
		Timestamp loginTime = new Timestamp(customerID);
		cdao.addCustomer(new Customer(customerID,  customerName,  custType,  isBlocked, dob,  isOnlineBanking));
		//
		CustomerKYC ck=new CustomerKYC(01,"abcde4444a");
		cdao.addCutomerKYC(12345991, ck);
		//
		ContactInfo co=new ContactInfo(01,"9934708668",01,false);
		ContactInfo co1=new ContactInfo(02,"aaasc@aa.com",01,false);
		cdao.addContactInfo(12345991, co);
		cdao.addContactInfo(12345991, co1);
	 /*   cdao.deleteCustomer(12345678);
		int customerID=12345678;
		String customerName="sri";
		int custType=01;
		boolean isBlocked=false;
	    Date dob=new Date(custType);
	    String str=dob.toString();
		boolean isOnlineBanking=false;
		Date date= new Date(7867563);
		Timestamp loginTime = new Timestamp(customerID);
		cdao.addCustomer(new Customer(customerID,  customerName,  custType,  isBlocked, dob,  isOnlineBanking) );
		List<Customer> clist = cdao.getAllCustomers();
		System.out.println(clist);
		Customer c=cdao.getCustomer(12345678);
		ContactInfo co=new ContactInfo(01,"9934708668",01,false);
		ContactInfo co1=new ContactInfo(02,"12345",01,false);
		cdao.addContactInfo(12345678, co);
		cdao.addContactInfo(12345678, co1);
		HashMap<String,ContactInfo> colist = cdao.getContactInfo(12345678);
		System.out.println(colist);
		CustomerAddress ca=new CustomerAddress("fwsedf","dfef",01,"dfsdfg","dfwsedgf");
        cdao.addCustomerAddress(12345678, ca);
        System.out.println(cdao.getCustomerAddress(12345678));
       CustomerKYC ck=new CustomerKYC(01,"jdgukwf");
       cdao.addCutomerKYC(12345678, ck);
       System.out.println(cdao.getCustomerKYCList(12345678));
       OnlineBankingCredentials ob=new OnlineBankingCredentials("qwerty","qwerty123");
       cdao.addOnlineBankingCredentials(ob, 12345678);
//       System.out.println(cdao.validate("qwerty", "qwerty123"));
//       
       
       CustomerService cs=new CustomerService();
      // cs.addOnlineBankingCredentials( "qwerty","qwerty123",12345678);
      // System.out.println("valid"+cdao.validate( "qwerty","qwerty123"));
       
       Account ac=new Account(123456789012L,new Date(53628715),12000,01);
       AccountType at= new AccountType(01,500,30000);
       adao.addAccountType(at);
       adao.addAccount(12345678, 01, ac);
       System.out.println("Allaccounts"+ adao.getAllAccounts());
       System.out.println(adao.getAccount(123456789012L));
       
       tdao.addTransactionType(23, "Credit");
	   Transaction t1= new Transaction(01, new Timestamp(date.getTime()),500,23,"new",123456789012L);
       tdao.addTransaction(t1);
       
       System.out.println(tdao.getTransactionByID(01));
       System.out.println(tdao.getRecentTransactionsByAccount(123456789012L, 1));
       
       System.out.println(cdao.addOnlineBanking(12345678));
       System.out.println("********************************");
      
       System.out.println(cdao.isExistingContact("9934708668"));
       CustomerService cusser = new CustomerService();
       System.out.println( cusser.removeCustomerWithoutAccount(12345678));
   
      System.out.println(cs.validateInfo(12345678,"", "9934708668", "",str));
      
       
*/
   

  
      
	}

}
