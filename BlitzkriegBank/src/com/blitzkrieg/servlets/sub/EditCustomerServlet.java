package com.blitzkrieg.servlets.sub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditCustomerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------");
		System.out.println("processing get request in edit servlet");
		request.setAttribute("result",  "something");
		request.setAttribute("view", "EditCustomerInfo");
		request.getRequestDispatcher("FrontController").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------");
		System.out.println("Processing post request in edit servlet.....");
	}

}
