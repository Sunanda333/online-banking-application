package com.blitzkrieg.dao.daoimpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.blitzkrieg.model.*;
import com.blitzkrieg.utils.Constants;

public class AccountDAOImpl {
	private final static String conURL = "jdbc:derby:" + Constants.BASE_PATH + "//bankDB";
	private static Connection conn=null;
	public AccountDAOImpl() {
	try {Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	//System.out.println("+++driver loaded+++");
	}catch(ClassNotFoundException e) {e.printStackTrace();}
}

	public void createConnection() {
		try {conn=DriverManager.getConnection(conURL);
		//System.out.println("+++connected++++");
		DatabaseMetaData dmd=conn.getMetaData();
//		System.out.println(dmd.getDatabaseProductName());
//		System.out.println(dmd.getDatabaseProductVersion());
//		System.out.println(dmd.getDriverName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

}

public void closeConnection() {
		if(conn!=null) {try {
				conn.close();
				//System.out.println("+++DB connection closed+++");
		}	catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
}
public void addAccountType(AccountType a) throws SQLException {
	createConnection();
	try {
	PreparedStatement smt1=conn.prepareStatement("insert into AccountType values (?,?,?,?)");
	smt1.setInt(1,a.getAccountType());
	smt1.setString(2,a.getTypeName());
	smt1.setFloat(3, a.getMinimumBalance());
	smt1.setFloat(4,a.getOverdraftAmountLimit());
	smt1.executeUpdate();
	smt1.close();
	System.out.println("record added to AccountType..... ");
	}
	
	catch(Exception e){
		System.out.println(e);
	}
	finally
	{
		closeConnection();
	}

}
public void addAccount(int customerID, int accountType,Account a) throws SQLException {
createConnection();

try {
	
	PreparedStatement smt=conn.prepareStatement("insert into Account values (?,?,?,?,?)");

	smt.setLong(1,a.getAccountID());
	smt.setInt(2,customerID);
	smt.setDate(3, (java.sql.Date) a.getOpeningDate());
	smt.setInt(4,accountType);
	smt.setFloat(5, a.getCurrentBalance());
	smt.executeUpdate();
	smt.close();

	System.out.println("Record Submitted to Account....");
	}
	catch(Exception e){
		System.out.println(e);
	}
	finally
	{
		closeConnection();
	}
}
public boolean isCreated(int customerID) {
	boolean status = false;
	createConnection();
	try {
		PreparedStatement ps = conn.prepareStatement("select * from Account where customerID=?");
		ps.setInt(1, customerID);
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		ps.close();
		ps.close();


	} catch (Exception e) {
		System.out.println(e);
	}
	return status;

}

public Account getAccount(long id) {
	Account account =null;
	createConnection();
	try {
		PreparedStatement prSt1 = conn.prepareStatement("select * from Account where accountID=?");
		 prSt1.setLong(1,id);
         ResultSet rs = prSt1.executeQuery();
         if(rs.next()){
         long accountID = rs.getLong(1);
         Date openingDate = rs.getDate(3);
         int accountType = rs.getInt(4);
         float currentBalance = rs.getFloat(5);
         account=new Account(accountID,openingDate,currentBalance,accountType);
         }
         rs.close();
     	prSt1.close();

    
     } catch (Exception e) {
         e.printStackTrace();
     }
	finally{
		closeConnection();
		}
	
	return account;
}
public List<Account> getAllAccounts() {
	ArrayList<Account> accountsList=new ArrayList<>();;
	
	createConnection();
	try {
		 String query = "select * from Account";
		 PreparedStatement prSt = conn.prepareStatement(query);
         ResultSet rs = prSt.executeQuery();
         while(rs.next()){
        	 long accountID = rs.getLong(1);
             Date openingDate = rs.getDate(3);
             int accountType = rs.getInt(4);
             float currentBalance = rs.getFloat(5);
             Account currentAccount=new Account(accountID,openingDate,currentBalance,accountType);
          
           accountsList.add(currentAccount);
         }
         rs.close();
     	prSt.close();

       
     } catch (Exception e) {
         e.printStackTrace();
     }
	finally{
    	 closeConnection();}
	return accountsList;
	
}

public List<Account> getAllAccountsofCustomer(int customerID) {
	ArrayList<Account> accountsList=new ArrayList<>();;
	
	createConnection();
	try {
		PreparedStatement prSt = conn.prepareStatement("select * from Account where customerID =?");
		 prSt.setInt(1,customerID);
         ResultSet rs = prSt.executeQuery();
         while(rs.next()){
           Account a =new Account();
           accountsList.add(a);
         }
         rs.close();
      	prSt.close();

       
     } catch (Exception e) {
         e.printStackTrace();
     }
	finally{
    	 closeConnection();}
	return accountsList;
	
}

public void deleteAccount(long accountID) {
	String sql="delete from Account where accountID=?";
	createConnection();
	try {PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setLong(1,accountID );
	int cnt=preparedStatement.executeUpdate();
	if(cnt!=0) {
	System.out.println("++++deleted the record from Account with id:"+accountID+"++++");	
	}
	preparedStatement.close();

	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		closeConnection();
	}
}

public void deleteAccountbyCustomerID(int customerID) {
	String sql="delete from Account where customerID=?";
	createConnection();
	try {PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setLong(1,customerID );
	int cnt=preparedStatement.executeUpdate();
	if(cnt!=0) {
	System.out.println("++++deleted the record from Account with id:"+customerID+"++++");	
	}
	preparedStatement.close();

	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		closeConnection();
	}
}
	
}