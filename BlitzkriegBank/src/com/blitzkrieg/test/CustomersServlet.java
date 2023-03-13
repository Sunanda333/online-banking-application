package com.blitzkrieg.test; 
  
import java.io.*; 
import java.util.ArrayList; 
import javax.servlet.*; 
import javax.servlet.http.*;

import com.blitzkrieg.model.Customer; 
  
public class CustomersServlet extends HttpServlet { 
  
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response) 
    throws ServletException, IOException 
    { 
     response.setContentType("text/html;charset=UTF-8"); 
     try (PrintWriter out = response.getWriter()) { 
       out.println("<!DOCTYPE html>"); 
       out.println("<html>"); 
       out.println("<head>"); 
       out.println("<title> CustomerServlet</title>"); 
       out.println("</head>"); 
       out.println("<body>"); 
       ArrayList<Customer> std = new ArrayList<Customer>(); 
       std.add(new Customer(1,"Roxy Willard", 0, false, null, false)); 
       std.add(new Customer(2,"Todd Lanz", 0, false, null, false)); 
         request.setAttribute("data", std); 
         RequestDispatcher rd =  
             request.getRequestDispatcher("customer.jsp"); 
          rd.forward(request, response); 
            out.println("</body>"); 
            out.println("</html>"); 
        } 
    } 
   
    @Override
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        processRequest(request, response); 
    } 
    @Override
    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        processRequest(request, response); 
    } 
    @Override
    public String getServletInfo() 
    { 
        return "Short description"; 
    } 
} 