package com.blitzkrieg.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blitzkrieg.utils.Constants;
import com.blitzkrieg.utils.Logg;
import com.blitzkrieg.utils.MappingHandler;
import com.blitzkrieg.utils.ViewResolver;

@WebServlet({ "/", "/customerRegisteration", "/editInfo", "/dashboard", "/cms", "/moneyTransfer", "/validation",
		"/openAccount", "/existingCustomer" ,"/validationTwo","/logout"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MappingHandler handler;
	ViewResolver resolver;

	public void init() throws ServletException {
		super.init();
		this.handler = new MappingHandler();
		this.resolver = new ViewResolver();
	}

	/*
	 * 
	 * 
	 * */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		Logg.debug("---------GET REQ IN FRONT CONTROLLER---------");
		HttpSession session = request.getSession();
		
		System.out.println(request.getRequestURL());
		if (request.getAttribute(Constants.RESULTS) == null) {
			dispatchToController(request, response);
		} else {
			dispatchToView(request, response);
		}
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---------POST REQ IN FRONT CONTROLLER---------");
		HttpSession session = request.getSession(false);
		if (request.getAttribute(Constants.RESULTS) == null) {
			dispatchToController(request, response);
		} else {
			dispatchToView(request, response);
		}
	}

	private void dispatchToController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Every fresh request from the client comes here
		System.out.println("New Request entered in Front controller: " + request.getRequestURL());

		// The appropriate controller is mapped here
		String controllerUrl = handler.mapUrlToServlet(request.getRequestURL().toString());

		// The request is dispatched to the respective Controller after mapping
		System.out.println("Request being dispatched to controller:" + controllerUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher(controllerUrl);
		dispatcher.forward(request, response);
	}

	private void dispatchToView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Every request processed from the controller comes here
		System.out.println("Request entered from the sub controller");
		String view = (String) request.getAttribute("view");

		// the appropriate view is resolved from the viewResolver and then dispatched to
		// it
		String viewUrl = resolver.resolveView(view);
		System.out.println("view url generated:: " + viewUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		dispatcher.forward(request, response);
	}
}