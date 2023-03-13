package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blitzkrieg.model.Customer;
import com.blitzkrieg.model.CustomerAddress;
import com.blitzkrieg.model.CustomerKYC;
import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.service.GenerateIDService;
import com.blitzkrieg.utils.Constants;

@WebServlet("/RegisterNewCustomerServlet")
public class RegisterNewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	private SimpleDateFormat formatter;

	public RegisterNewCustomerServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		customerService = new CustomerService();
		formatter = new SimpleDateFormat("dd-mm-yyyy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Processing get request in RegisterNewServlet...");
		request.setAttribute(Constants.JSP_VIEW,  "RegisterNewCustomer");
		request.setAttribute(Constants.RESULTS,  "something");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Processing post request in the RegisterNewCustomerServlet controller...");
		
		//if we want to open account for existing customer
		if (request.getParameter("customerId") != null) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			Customer customer = customerService.getDetails(customerId);
			CustomerAddress customerAddress = customerService.getCustomerAddress(customerId);
			List<CustomerKYC> customerKYCs = customerService.getCustomerKYCList(customerId);
			
			request.setAttribute(Constants.CUSTOMER,  customer);
			request.setAttribute(Constants.CUSTOMER_ADDRESS, customerAddress);
			request.setAttribute(Constants.CUSTOMER_KYC, customerKYCs.get(0));
			
			request.setAttribute(Constants.RESULTS,  "Opening account for existing customer");
			request.setAttribute(Constants.JSP_VIEW,  "RegisterNewCustomer");
			request.getRequestDispatcher("FrontController").forward(request, response);
			return;
		}
		
		//if we want to open account for new customer
		int id = GenerateIDService.generateCustomerID();
		
		String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
		String panNumber = request.getParameter("pan");
		Date dob = null;
		try {
			dob = new Date(formatter.parse(request.getParameter("dob")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String phoneNumber = request.getParameter("pnum");
		String email = request.getParameter("pemail");
		String altPhoneNumber = request.getParameter("anum");
		String altEmail = request.getParameter("aemail");
		String buildingName = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int pin = Integer.parseInt(request.getParameter("pin"));
		String country = request.getParameter("country");
		String typeOfAccount = request.getParameter("typeOfAccount");
		int accountType = -1;
		if (typeOfAccount.equals("Savings")) {
			accountType = 1;
		} else if (typeOfAccount.equals("Current")) {
			accountType = 2;
		}
		String deposit = request.getParameter("deposit");
		String maintain = request.getParameter("maintain");
		String overdraft = request.getParameter("overdraft");
		
		CustomerAddress address = new CustomerAddress(buildingName, city, pin, state, country);
		CustomerKYC customerKYC = new CustomerKYC(1,  panNumber);
		
		customerService.addCustomer(new Customer(id, name, accountType, false, dob, false), address, customerKYC);
		
		request.setAttribute(Constants.JSP_VIEW,  "CMS");
		request.setAttribute(Constants.RESULTS,  Constants.CUSTOMER_ADDED_SUCCESSFULLY);
		request.getRequestDispatcher("FrontController").forward(request,  response);
	}
}
