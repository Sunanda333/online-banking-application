package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.utils.Constants;

@WebServlet("/ExistingCustomerServlet")
public class ExistingCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;

	public ExistingCustomerServlet() {
		customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----Processing get request in Exitsting customer servlet-----");
		request.setAttribute(Constants.RESULTS, customerService.getAllCustomers());
		request.setAttribute(Constants.JSP_VIEW, "ExistingCustomer");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----Processing post request in Exitsting customer servlet-----");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		request.setAttribute(Constants.CUSTOMER, customerService.getDetails(customerId));
		request.setAttribute(Constants.JSP_VIEW,  "ExistingCustomer");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

}
