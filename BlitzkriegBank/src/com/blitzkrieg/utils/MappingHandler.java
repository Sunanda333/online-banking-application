package com.blitzkrieg.utils;

import java.util.HashMap;
import java.util.Map;

public class MappingHandler {
	private static Map<String, String> urlMap;

	public MappingHandler() {
		urlMap = new HashMap<String, String>();
		urlMap.put("", "HomePageServlet");
		urlMap.put("/customerRegisteration", "CustomerRegisteratonServlet");
		urlMap.put("/validation", "ValidationServlet");
		urlMap.put("/openAccount", "RegisterNewCustomerServlet");
		urlMap.put("/dashboard", "HomePageServlet");
		urlMap.put("/cms", "HomePageServlet");
		urlMap.put("/", "HomePageServlet");
		urlMap.put("/editInfo", "EditCustomerServlet");
		urlMap.put("/moneyTransfer", "MoneyTransferServlet");
		urlMap.put("/resgister", "RgisterServlet");
		urlMap.put("/login", "LoginServlet");
		urlMap.put("/home", "HomePageServlet");
		urlMap.put("/profile", "");
		urlMap.put("/transferFunds", "");
		urlMap.put("/existingCustomer", "ExistingCustomerServlet");
		urlMap.put("/validationTwo", "Validation2Servlet");
		urlMap.put("/logout", "LogoutServlet");
	}

	/*
	 * This methods maps the url pattern to the appropriate controller
	 * 
	 */
	public String mapUrlToServlet(String url) {
		String targetUrl = url.replaceFirst(Constants.BASE_URL, "");
		return urlMap.get(targetUrl);
	}
}