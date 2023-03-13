package com.blitzkrieg.servlets.sub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blitzkrieg.Exception.UserNameExistException;
import com.blitzkrieg.service.CustomerService;
import com.blitzkrieg.utils.Constants;
import com.blitzkrieg.utils.Logg;

/**
 * Servlet implementation class Validation2Servlet
 */
@WebServlet("/Validation2Servlet")
public class Validation2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService custService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Validation2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		custService=new CustomerService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * To check and insert new Login Creds
		 */
		int customerId=0;
		try {
			HttpSession session=request.getSession(false);
			Logg.debug("Entered post of validate2Servlet");
			String username=request.getParameter("userName");
			String password=request.getParameter("password");
			customerId = (int)session.getAttribute("customerId");
			custService.addOnlineBankingCredentials(username, password,customerId);
			//needs to add confirmation to show customers online banking creds have been created
			response.sendRedirect("/BlitzkriegBank");
		}catch(UserNameExistException e) {
			//If 
			Logg.debug("OnlineBnkingCredCreate: UserNameExist occured for:"+customerId);
			request.setAttribute("view",  "ValidationTwo");
			request.setAttribute(Constants.RESULTS, "validation2Serv");
			request.setAttribute(Constants.ACTION_MESSAGE, "User Name Exist:Choose another one!");
			request.getRequestDispatcher("FrontController").forward(request, response);

		}
		
		
		
	}

}
