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

<form action="validationTwo" method="post">
<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Customer Registration</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">Desired Username</label>
					<input id="user" name="userName" type="text" class="input" onkeyup="validateUsername(user)"> <span id="error19"></span>
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="password" name="password" type="password" class="input" data-type="password"> <span id="msg"></span>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Submit" >
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
