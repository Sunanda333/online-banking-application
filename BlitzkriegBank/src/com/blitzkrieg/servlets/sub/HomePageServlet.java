package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blitzkrieg.Exception.InvalidLoginCredentialsException;
import com.blitzkrieg.model.Account;
import com.blitzkrieg.model.Customer;
import com.blitzkrieg.service.AccountService;
import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.service.EmployeeService;
import com.blitzkrieg.service.LoginService;
import com.blitzkrieg.utils.Constants;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private LoginService loginService;
	private CustomerService customerService;
	private AccountService accountService;

	@Override
	public void init() throws ServletException {
		super.init();
		String relativePath = "/WEB-INF/employee.xml";
		String absolutePath = getServletContext().getRealPath(relativePath);
		employeeService = new EmployeeService(absolutePath);
		loginService = new LoginService();
		customerService = new CustomerService();
		accountService = new AccountService();
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Processing the get request in the HomePageServlet controller");
		request.setAttribute(Constants.RESULTS, "something");
		request.setAttribute("view", "HomePage");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			if (request.getParameter("typeOfLogin").equals("customerLogin")) {
				System.out.println("Customer Login initiated");
				String userName = request.getParameter("customer_username");
				String password = request.getParameter("customer_psw");
				int customerId = loginService.validate(userName, password);
				if (customerId != -1) {
					request.setAttribute("view", "Dashboard");
					request.setAttribute(Constants.RESULTS, Constants.SIGN_IN_SUCCESSFUL);
					Customer customer = customerService.getDetails(customerId);
					List<Account> accounts = accountService.getAllAccountsofCustomer(customerId);
					session.setAttribute(Constants.ALL_ACCOUNT_DETAILS, accounts);
					session.setAttribute(Constants.CUSTOMER_DETAILS, customer);
					session.setAttribute(Constants.ACTION_MESSAGE, Constants.SIGN_IN_SUCCESSFUL);
					request.getRequestDispatcher("FrontController").forward(request, response);
				} else {
					throw new InvalidLoginCredentialsException();
				}
			} else if (request.getParameter("typeOfLogin").equals("employeeLogin")) {
				System.out.println("Employee Login initiated");
				String userName = request.getParameter("employee_username");
				String password = request.getParameter("employee_psw");
				if (employeeService.validateEmployee(userName, password)) {
					request.setAttribute("view", "CMS");
					request.setAttribute(Constants.RESULTS, Constants.SIGN_IN_SUCCESSFUL);
					session.setAttribute(Constants.ACTION_MESSAGE, Constants.SIGN_IN_SUCCESSFUL);
					session.setAttribute(Constants.USER, userName);
					request.getRequestDispatcher("FrontController").forward(request, response);
				} else {
					throw new InvalidLoginCredentialsException();
				}
			}
		} catch (InvalidLoginCredentialsException e) {
			System.out.println(e);
			session.setAttribute(Constants.ACTION_MESSAGE, Constants.SIGN_IN_UNSUCCESSFUL);
			response.sendRedirect("/BlitzkriegBank");
		}
	}
}