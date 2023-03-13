package com.blitzkrieg.servlets.sub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blitzkrieg.Exception.OnlineBankingExistsException;
import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.utils.Constants;

@WebServlet("/CustomerRegisteratonServlet")
public class CustomerRegisteratonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customerService;
    public CustomerRegisteratonServlet() {
        super();
        customerService = new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------");
		System.out.println("processing get request in customer-registeration-servlet");
		request.setAttribute(Constants.RESULTS,  "something");
		request.setAttribute("view", "CustomerRegisteration");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------");
		System.out.println("Processing post request in customer registeration servlet.....");
		HttpSession session = request.getSession(false);
		System.out.println(request.getParameter("customer_id"));
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		String nameOfAccount = request.getParameter("name_of_account");
		try {
			if (customerService.validateCustomer(customerId, nameOfAccount)) {
				request.setAttribute(Constants.RESULTS,  Constants.VALID_USER);
				request.setAttribute(Constants.JSP_VIEW,  "ValidationOne");
				session.setAttribute("customerId", customerId);
				request.getRequestDispatcher("FrontController").include(request, response);
			} else {
				request.setAttribute(Constants.RESULTS,  Constants.WRONG_INPUT);
				request.setAttribute(Constants.JSP_VIEW,  "CustomerRegisteration");
				request.getRequestDispatcher("FrontController").forward(request, response);
			}
		} catch (OnlineBankingExistsException e) {
			session.setAttribute(Constants.ACTION_MESSAGE, Constants.ALREADY_REGISTERED);
			response.sendRedirect("/BlitzkriegBank");
		}
	}
}
