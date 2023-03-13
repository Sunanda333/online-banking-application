package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoneyTransferServlet
 */
@WebServlet("/MoneyTransferServlet")
public class MoneyTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MoneyTransferServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------");
		System.out.println("processing get request in money-transfer-servlet");
		request.setAttribute("result",  "something");
		request.setAttribute("view", "MoneyTransfer");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------");
		System.out.println("Processing post request in money transfer servlet.....");
	}

}
