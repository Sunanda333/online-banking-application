package com.blitzkrieg.dao.daoimpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.blitzkrieg.model.ContactInfo;
import com.blitzkrieg.model.Customer;
import com.blitzkrieg.model.CustomerAddress;
import com.blitzkrieg.model.CustomerKYC;
import com.blitzkrieg.model.OnlineBankingCredentials;
import com.blitzkrieg.utils.Constants;
import com.blitzkrieg.utils.EncryptDecryptString;
import com.blitzkrieg.utils.Logg;

public class CustomerDAOImpl {
	private final static String conURL = "jdbc:derby:" + Constants.BASE_PATH + "\\bankDB";
	private static Connection conn = null;
	
	public CustomerDAOImpl() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//System.out.println("+++driver loaded+++");
	    } catch (ClassNotFoundException e){
	    		e.printStackTrace();
	      	}  
	}
	

	public void createConnection() {
		try {
			conn = DriverManager.getConnection(conURL);
			//System.out.println("+++connected++++");
			DatabaseMetaData dmd = conn.getMetaData();
//			System.out.println(dmd.getDatabaseProductName());
//			System.out.println(dmd.getDatabaseProductVersion());
//			System.out.println(dmd.getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		  	}

	}
	
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				//System.out.println("+++DB connection closed+++");
			} catch (SQLException e) {
				e.printStackTrace();
			  	}
		}
	}

	public void addCustomer(Customer c)  {
		createConnection();

		try {
			PreparedStatement smt = conn.prepareStatement("insert into Customer values (?,?,?,?,?,?)");
			smt.setInt(1, c.getCustomerID());
			smt.setString(2, c.getCustomerName());
			smt.setDate(3, c.getDob());
			smt.setBoolean(4, c.isBlocked());
			smt.setInt(5, c.getCustType());
			smt.setBoolean(6, c.isOnlineBanking());
			smt.executeUpdate();
			System.out.println("Customer added...");

			smt.close();
		} catch (Exception e) {
			e.printStackTrace();
		  	}
		finally {
			closeConnection();
			}
	}
	
	public boolean addOnlineBanking(int customerID){
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("UPDATE Customer SET isOnlineBanking = true WHERE customerID = ?");
			smt.setInt(1, customerID);
			smt.executeUpdate();
			System.out.println("OnlineBanking added...");
			smt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		  	}
		finally {
			closeConnection();
		}
		return false;
	}

	public boolean blockCustomer(int customerID){
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("UPDATE Customer SET isBlocked  = true WHERE customerID = ?");
			smt.setInt(1, customerID);
			smt.executeUpdate();
			System.out.println("Customer is blocked...");
			smt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		  	}
		finally {
			closeConnection();
		}
		return false;
	}
	
	public void addCutomerKYC(int customerID, CustomerKYC c){
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("INSERT INTO CustomerKYC ( customerID, verifyNo, verifyTypeID) values (?,?,?)");
			smt.setInt(1, customerID);
			smt.setString(2, c.getKYCNo());
			smt.setInt(3, c.getKYCType());

			smt.executeUpdate();
			System.out.println("Record Submitted to CustomerKYC....");
			smt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public void addCustomerAddress(int customerID, CustomerAddress c) {
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("insert into CustomerAddress values (?,?,?,?,?,?)");
			smt.setInt(1, customerID);
			smt.setString(2, c.getBuildingName());
			smt.setString(3, c.getCity());
			smt.setInt(4, c.getPincode());
			smt.setString(5, c.getState());
			smt.setString(6, c.getCountry());
			smt.executeUpdate();
			System.out.println("Record Submitted to CustomerAddress....");
			smt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void addOnlineBankingCredentials(OnlineBankingCredentials c, int customerID) {
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("insert into OnlineBankingCredentials values (?,?,?)");
			smt.setString(1, c.getUserName());
			smt.setInt(2, customerID);
			smt.setString(3, c.getPassword());
			smt.executeUpdate();
			smt.close();
			Logg.debug("New OnlineBankingCreds Added");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void addContactInfo(int customerID, ContactInfo c) throws SQLException {
		createConnection();
		try {
			PreparedStatement smt = conn.prepareStatement("INSERT INTO ContactInfo ( customerID, contactInfo, contactTypeID, isPrimary) values (?,?,?,?)");
			smt.setInt(1, customerID);
			smt.setString(2, c.getContactInfo());
			smt.setInt(3, c.getContactType());
			smt.setBoolean(4, c.getisPrimary());
			smt.executeUpdate();
			System.out.println("Record Submitted to ContactInfo....");
			smt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public Customer getCustomer(int customerID) {
		Customer customer = null;

		createConnection();
		try {
			PreparedStatement prSt1 = conn.prepareStatement("select * from Customer where customerID=?");
			prSt1.setInt(1, customerID);
			ResultSet rs = prSt1.executeQuery();
			if (rs.next()) {
				int currentcustomerID = rs.getInt(1);
				String customerName = rs.getString(2);
				Date dob = rs.getDate(3);
				boolean isBlocked = rs.getBoolean(4);
				int custType=rs.getInt(5);
				boolean isOnlineBanking = rs.getBoolean(6);
				customer = new Customer(currentcustomerID,customerName,custType, isBlocked, dob, isOnlineBanking);
			}
			rs.close();
			prSt1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return customer;
	}
	
	public List<ContactInfo> getContactInfoList(int customerID) {
		List<ContactInfo>  listcontactinfo = new ArrayList<>() ;
		createConnection();
		try {
			
			PreparedStatement prSt1 = conn.prepareStatement("select * from ContactInfo where customerID=?");
			prSt1.setInt(1, customerID);
			ResultSet rs = prSt1.executeQuery();
			if (rs.next()) {
				int contactID=rs.getInt(1);
				String contactInfo=rs.getString(3);
				int contactType=rs.getInt(4);
				boolean isPrimary=rs.getBoolean(5);
				ContactInfo contactinfo = new ContactInfo(contactID,contactInfo,contactType, isPrimary);
				listcontactinfo.add(contactinfo);
			}
			rs.close();
			prSt1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return listcontactinfo;
	}
	public List<CustomerKYC> getCustomerKYCList(int customerID) {
		List <CustomerKYC> listcustomerkyc = new ArrayList<>();
		createConnection();
		try {
			PreparedStatement prSt1 = conn.prepareStatement("select * from CustomerKYC where customerID=?");
			prSt1.setInt(1, customerID);
			ResultSet rs = prSt1.executeQuery();
			if (rs.next()) {
			 String KYCNo=rs.getString(2);
			 int KYCType=rs.getInt(3);			
			 CustomerKYC customerkyc = new 	CustomerKYC(KYCType,KYCNo);
			 listcustomerkyc.add(customerkyc);
			}
			rs.close();
			prSt1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return listcustomerkyc;
	}
	public CustomerAddress getCustomerAddress(int customerID) {
		CustomerAddress customeraddress = null;

		createConnection();
		try {
			PreparedStatement prSt1 = conn.prepareStatement("select * from CustomerAddress where customerID=?");
			prSt1.setInt(1, customerID);
			ResultSet rs = prSt1.executeQuery();
			if (rs.next()) {
				String buildingName=rs.getString(2);
				String city=rs.getString(3);
				int pincode=rs.getInt(4);
				String state=rs.getString(5);
				String country=rs.getString(6);
				
				customeraddress = new CustomerAddress(buildingName,city,pincode,state,country);
			}
			rs.close();
			prSt1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return customeraddress;
	}
	

	public List<Customer> getAllCustomers() {
		ArrayList<Customer> customersList = new ArrayList<>();
		createConnection();
		try {
			
			String query = "select * from Customer";
			PreparedStatement prSt = conn.prepareStatement(query);
			ResultSet rs = prSt.executeQuery();
			while (rs.next()) {
				int currentcustomerID = rs.getInt(1);
				String customerName = rs.getString(2);
				Date dob = rs.getDate(3);
				boolean isBlocked = rs.getBoolean(4);
				int custType=rs.getInt(5);
				boolean isOnlineBanking = rs.getBoolean(6);
				Customer currentCustomer = new Customer(currentcustomerID,customerName,custType, isBlocked, dob, isOnlineBanking);
				customersList.add(currentCustomer);
			}
			rs.close();
			prSt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return customersList;
	}



	public void deleteCustomer(int customerID) throws SQLException {
		createConnection();
		try {
	  PreparedStatement smt=conn.prepareStatement("delete from onlinebankingcredentials where customerID=?");
	  smt.setInt(1,customerID);
	  int cnt=smt.executeUpdate();
		smt.close();

	  if(cnt!=0) {
		  System.out.println("++++deleted from onlinebankingcredentials with customerID:"+customerID+"+++++");
		  }
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement1 = conn.prepareStatement("delete from CustomerKYC where customerID=?");
			preparedStatement1.setInt(1, customerID);
			
			int cnt = preparedStatement1.executeUpdate();
			preparedStatement1.close();

			if (cnt != 0) {
				System.out.println("++++deleted from CustomerKYC with record customerID:" + customerID + "++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			AccountDAOImpl accountdaoimpl = new AccountDAOImpl();
			accountdaoimpl.deleteAccountbyCustomerID(customerID);
			PreparedStatement preparedStatement2 = conn.prepareStatement("delete from ContactInfo where customerID=?");
			preparedStatement2.setInt(1, customerID);
			int cnt = preparedStatement2.executeUpdate();
			preparedStatement2.close();

			if (cnt != 0) {
				System.out.println("++++deleted from ContactInfo with record customerID:" + customerID + "++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement3 = conn.prepareStatement("delete from CustomerAddress where customerID=?");
			preparedStatement3.setInt(1, customerID);
			int cnt = preparedStatement3.executeUpdate();
			preparedStatement3.close();

			if (cnt != 0) {
				System.out.println("++++deleted from CustomerAddress with record customerID:" + customerID + "++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement3 = conn.prepareStatement("delete from Customer where customerID=?");
			preparedStatement3.setInt(1, customerID);
			int cnt = preparedStatement3.executeUpdate();
			preparedStatement3.close();

			if (cnt != 0) {
				System.out.println("++++deleted from Customer  with record customerID:" + customerID + "++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
			closeConnection();
		

	}

	public int validate(String userName, String userPassword) {
		createConnection();
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement("select * from OnlineBankingCredentials where userName=? and password=?");
			ps.setString(1, userName);
			String userPasswordEncrypted=EncryptDecryptString.encrypt(userPassword);
			ps.setString(2, userPasswordEncrypted);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("CUSTOMERID");
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	public boolean isValidCustomer(int customerID) {
		boolean status = false;
		createConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Customer where customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			ps.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
public boolean isExistingContact(String contact) {
	boolean status = false;
	createConnection();
	try {
		PreparedStatement ps = conn.prepareStatement("select * from ContactInfo where contactinfo=?");
		ps.setString(1, contact);
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		ps.close();

	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}
public HashMap<String,ContactInfo> getContactInfo(int customerID) {
	 HashMap<String,ContactInfo> hm=new HashMap<String,ContactInfo>();
	createConnection();
	try {
		PreparedStatement prSt1 = conn.prepareStatement("select * from ContactInfo where customerID=?");
		prSt1.setInt(1, customerID);
		ResultSet rs = prSt1.executeQuery();
		while(rs.next()) {
			int contactID=rs.getInt(1);
			String contactInfo=rs.getString(3);
			int contactType=rs.getInt(4);
			boolean isPrimary=rs.getBoolean(5);
			ContactInfo contactinfo = new ContactInfo(contactID,contactInfo,contactType, isPrimary);
			hm.put(contactInfo, contactinfo);
		
		}
		rs.close();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		closeConnection();
	}
	return hm;
}
public HashMap<String,CustomerKYC> getCustomerKYC(int customerID) {
	HashMap <String,CustomerKYC> listcustomerkyc = new HashMap<String,CustomerKYC>();
	createConnection();
	try {
		PreparedStatement prSt1 = conn.prepareStatement("select * from CustomerKYC where customerID=?");
		prSt1.setInt(1, customerID);
		ResultSet rs = prSt1.executeQuery();
		while(rs.next()) {
		 String KYCNo=rs.getString(2);
		 int KYCType=rs.getInt(3);			
		 CustomerKYC customerkyc = new 	CustomerKYC(KYCType,KYCNo);
		 listcustomerkyc.put(KYCNo,customerkyc);
		}
		rs.close();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		closeConnection();
	}
	return listcustomerkyc;
}
}