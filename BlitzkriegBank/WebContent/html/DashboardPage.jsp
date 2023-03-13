<%@page import="java.util.ArrayList"%>
<%@page import="com.blitzkrieg.model.Customer"%>
<%@page import="com.blitzkrieg.model.Account"%>

<%@page import="com.blitzkrieg.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
		<%@ include file="css/layouts/side-menu.css"%>
		<%@ include file="css/accountTable.css" %>
		
	</style>
    <title>Blitzkrieg Bank</title>
</head>
<body>

<%
	Customer customer = (Customer) session.getAttribute(Constants.CUSTOMER_DETAILS);
	ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute(Constants.ALL_ACCOUNT_DETAILS);
%>
<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="HomePage.html">Blitzkrieg</a>

            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="#cust-info" class="pure-menu-link">Customer Information</a></li>
                <li class="pure-menu-item"><a href="#account-info" class="pure-menu-link">Account Details</a></li>

                <li class="pure-menu-item menu-item-divided pure-menu-selected">
                    <a href="editInfo" class="pure-menu-link">Edit Information</a>
                </li>

                <li class="pure-menu-item"><a href="moneyTransfer" class="pure-menu-link">Money Transfer</a></li>
                <li class="pure-menu-item"><a href="#" class="pure-menu-link">Logout</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
        
        <div class="header">
            <h1>Customer Dashboard</h1>
            <h4 style='text-align:right'><%= customer.getCustomerName() %>  </h2>
             <h4 style='text-align:right'><%= customer.getDob() %>  </h2>
        </div>

        <div class="content">
		<div id="cust-info">
            <h2 class="content-subhead">Customer Info</h2><hr/>
            <h4>Customer Id:<span class="cust-detail"><%= customer.getCustomerID() %></span></h4>
			
            <h4>Customer Name:<span class="cust-detail"><%= customer.getCustomerName() %></span></h4>
			
            <h4>Login Time:<span class="cust-detail"><%= "to be done..." %></span></h4>
			
            <h2 class="content-subhead">List of account:</h2><hr/>
            
            <table>
            	<thead>
            		<tr>
            			<th>Account Number</th>
            			<th>Account Type</th>
            			<th>Current Balance</th>
            			<th>Opening Date</th>
            		</tr>
            	</thead>
            	<% for (Account account: accounts) {
            	%>	
            		<tr>
            			<td><%= account.getAccountID() %></td>
            			<td><%= account.getAccountTypeID() %></td>
            			<td><%= account.getCurrentBalance() %></td>
            			<td><%= account.getOpeningDate() %></td>
            		</tr>
            	<% }%>
            </table>

		</div>
        </div>
    </div>
</div>

<script src="js/ui.js"></script>

</body>
</html>