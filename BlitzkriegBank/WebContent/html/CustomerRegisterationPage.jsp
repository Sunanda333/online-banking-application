<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	<%@ include file="../html/js/validation.js" %>
</script>
<style><%@ include file="css/register.css"%></style>
<style><%@ include file="css/CustomerRegistrationHeader.css"%></style>
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

<form action="customerRegisteration" method="post">
<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Customer Registration</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">Customer ID</label>
					<input id="user" type="text" name="customer_id" class="input" onkeyup="validateCust(user)"> <span id="error17"></span>
				</div>
				<div class="group">
					<label for="pass" class="label">Name of Person/Business</label>
					<input id="nameperson" type="text" name="name_of_account" class="input" onkeyup="validateName(nameperson)"> <span id="error18"></span>
				</div>
				<!-- <div class="group">
					<input id="check" type="checkbox" class="check" checked>
					<label for="check"><span class="icon"></span> Keep me Signed in</label>
				</div> -->
				<div class="group">
					<input type="submit" class="button" value="Next" >
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
