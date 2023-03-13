package com.blitzkrieg.utils;

import java.util.HashMap;
import java.util.Map;

public class ViewResolver {
	
	private static Map<String, String> viewMap;
	
	public ViewResolver() {
		viewMap = new HashMap<String, String>();
		viewMap.put("HomePage", "html/HomePage.jsp");
		viewMap.put("CustomerRegisteration",  "html/CustomerRegisterationPage.jsp");
		viewMap.put("Dashboard", "html/DashboardPage.jsp");
		viewMap.put("CMS", "html/CMSPage.jsp");
		viewMap.put("EditCustomerInfo", "html/EditCustomerInfoPage.jsp");
		viewMap.put("MoneyTransfer", "html/MoneyTransferPage.jsp");
		viewMap.put("FundsTransferPageServlet", "html/HomePage.jsp");
		viewMap.put("ValidationOne",  "html/ValidationOnePage.jsp");
		viewMap.put("ValidationTwo",  "html/ValidationTwoPage.jsp");
		viewMap.put("RegisterNewCustomer", "html/RegisterNewCustomerPage.jsp");
		viewMap.put("LoginPageServlet", "html/LoginPage.jsp");
		viewMap.put("ExistingCustomer", "html/ExistingCustomerPage.jsp");
	}
	
	public String resolveView(String controller) {
		return viewMap.get(controller);
	}
}
