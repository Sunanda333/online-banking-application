package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.utils.Constants;
import com.blitzkrieg.utils.Logg;
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	
    public ValidationServlet() {
        super();
        customerService = new CustomerService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------Processing post request in validation one servlet.....-----");
		
		HttpSession session=request.getSession(false);
		int customerId = (int)session.getAttribute("customerId");
		String panNumber = request.getParameter("pan_number");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone_number");
		String date = request.getParameter("date");
		if(customerService.validateInfo(customerId, panNumber, email, phoneNumber, date)) {
			//Sucess
			Logg.debug("Successfully validated customer info in validationServlet");
			request.setAttribute(Constants.RESULTS, Constants.CUSTOMER_VALIDATION_ONE);
			request.setAttribute("view",  "ValidationTwo");
			//session.setAttribute("customerId",  customerId);
			request.getRequestDispatcher("FrontController").forward(request, response);
		}else {
			//Wrong details entered
			request.setAttribute(Constants.RESULTS, Constants.CUSTOMER_VALIDATION_ONE);
			request.setAttribute("view",  "ValidationOne");
			request.getRequestDispatcher("FrontController").forward(request, response);
		}
		
	
	}
}