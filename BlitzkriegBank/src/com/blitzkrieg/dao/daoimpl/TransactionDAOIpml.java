package com.blitzkrieg.dao.daoimpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.blitzkrieg.model.Transaction;
import com.blitzkrieg.utils.Constants;

public class TransactionDAOIpml {
	private final static String conURL = "jdbc:derby:" + Constants.BASE_PATH + "//bankDB";
	private static Connection conn=null;
	public TransactionDAOIpml() {
	try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	//	System.out.println("+++driver loaded+++");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
}

	public void createConnection() {
		try {conn=DriverManager.getConnection(conURL);
	//	System.out.println("+++connected++++");
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

	public void addTransactionType(int transactionTypeID,String transactionName) throws SQLException {
		createConnection();
		try {
			PreparedStatement smt2=conn.prepareStatement("INSERT INTO TransactionType ( transactionTypeID, transactionName) values (?,?)");
			smt2.setInt(1, transactionTypeID);
			smt2.setString(2, transactionName);
			smt2.executeUpdate();
			System.out.println("Record Submitted to TransactionType....");

			}catch(Exception e){
				System.out.println(e);
			}finally {
		    	 closeConnection();
		    	 }
	}
	
	public void addTransaction(Transaction a) {
	createConnection();
	try {
		
		PreparedStatement smt2=conn.prepareStatement("insert into Transactions values (?,?,?,?,?,?)");
		
		smt2.setInt(1, a.getTransactionID());
		smt2.setLong(2, a.getAccountID());
		smt2.setTimestamp(3, a.getTimeStamp());
		smt2.setInt(4, a.gettransactionTypeID());
		smt2.setString(5, a.getRemarks());
		smt2.setFloat(6, a.getAmount());
		smt2.executeUpdate();
	
		System.out.println("Record Submitted to Transactions....");
		
		}catch(Exception e){
			System.out.println(e);
		}finally {
	    	 closeConnection();
	    	 }
}
	
public Transaction getTransactionByID(int transactionID) {
Transaction transaction =null;
	createConnection();
	try {
		PreparedStatement prSt1 = conn.prepareStatement("select * from Transactions where transactionID=?");
		prSt1.setInt(1,transactionID);
         ResultSet rs = prSt1.executeQuery();
         if(rs.next()){
        	 int currtransactionID = rs.getInt(1);
          	 long accountID=rs.getLong(2);
          	 Timestamp timeStamp=rs.getTimestamp(3);
             int transactionType=rs.getInt(4);
        	 String remarks=rs.getString(5);
        	 float amount=rs.getFloat(6);
        	 transaction=new Transaction(currtransactionID, timeStamp, amount,  transactionType,  remarks, accountID);
         }
         rs.close();
    
     } catch (Exception e) {
         e.printStackTrace();
     }finally {
    	 closeConnection();}
	return transaction;
}

public List<Transaction> getRecentTransactionsByAccount(long accountID, int number) {
	number = number -1;
	ArrayList<Transaction> transactionsList=new ArrayList<>();
	
	createConnection();
	try {
		 String query = "select * from Transactions where accountID=?";
		 PreparedStatement prSt = conn.prepareStatement(query);
		    prSt.setLong(1,accountID);
         ResultSet rs = prSt.executeQuery();
         while(rs.next()){
        	 int transactionID = rs.getInt(1);
          	 long curraccountID=rs.getLong(2);
          	 Timestamp timeStamp=rs.getTimestamp(3);
             int transactionType=rs.getInt(4);
        	 String remarks=rs.getString(5);
        	 float amount=rs.getFloat(6);
             Transaction currentTransaction=new Transaction(transactionID, timeStamp, amount,  transactionType,  remarks, curraccountID);
             transactionsList.add(currentTransaction);
         }
         rs.close();
    
     } catch (Exception e) {
         e.printStackTrace();
     }finally {
    	 closeConnection();}
	Collections.reverse(transactionsList);
	if(number>transactionsList.size()) {
    List<Transaction> lasttransactionsList = transactionsList.subList(0, number);
    return lasttransactionsList;
	}
	return transactionsList;
}


	
}