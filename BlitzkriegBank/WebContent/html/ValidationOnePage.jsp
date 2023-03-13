<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	<%@ include file="../html/js/validation.js" %>
</script>
<style>
	<%@ include file="css/register.css"%>
	<%@ include file="css/CustomerRegistrationHeader.css"%>
</style>
</head>
<body>

		<div class="topnav" id="myTopnav">
				<a href="#home" class="active">Home</a>
				<a href="#news">Banking</a>
				<a href="#contact">Contact</a>
				<a href="#about">About</a>
			
				
				<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <div class="me-icon"></div>
	<div class="me-icon"></div>
	<div class="me-icon"></div>
      <i class="fa fa-bars"></i>
    </a>
			  </div>
			  <script>
			function myFunction() {
			  var x = document.getElementById("myTopnav");
			  if (x.className === "topnav") {
				x.className += " responsive";
			  } else {
				x.className = "topnav";
			  }
			}
			</script>
<form action="validation" method="post">

<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Customer Registration</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm">
				
				<%
					ArrayList<Integer> index = new ArrayList<>();
					index.add(0); index.add(1); index.add(2); index.add(3);
					Collections.shuffle(index);
					int field1 = index.get(0);
					int field2 = index.get(1);
					if (field1 == 0 || field2 == 0) {
				%>
				<div class="group">
					<label for="user" class="label">PAN number</label>
					<input id="pan" type="text" class="input" name="pan_number" onkeyup="fnValidatePAN(pan)"><span id="error1"></span>
				</div>
				<%}
					if (field1 == 1 || field2 == 1) {
				%>
				<div class="group">
					<label for="pass" class="label">Email Address</label>
					<input id="pemail" type="text" class="input" name="email" onkeyup="validateEmail(pemail)"> <span id="error4"></span>
				</div>
				<%}
					if (field1 == 2 || field2 == 2) {
				%>
				<div class="group">
					<label for="pass" class="label">Date of Birth</label>
					<input id="dob" type="date" class="input" name="date" onkeyup="validatedate(dob)"><span id="error2"></span>
				</div>
				<%}
					if (field1 == 3 || field2 == 3) {
				%>
				<div class="group">
					<label for="pass" class="label">Phone number</label>
					<input id="pnum" type="text" class="input" name="phone_number" onkeyup="phonenumber(pnum)"> <span id="error3"></span>
				</div>
				<%} %>
				<div class="group">
					<input type="submit" class="button" value="Validate" href="validation.html">
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</form>
	<div class="footer">
<%@include file="footer.jsp" %>
</div>
</body>
</html>
