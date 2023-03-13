<%@page import="com.blitzkrieg.utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<!DOCTYPE html>
<html>
<head>

<style><%@include file="css/header.css"%></style>
<style><%@include file="css/login.css"%></style>
<style>
html{
	background-color:#ff6f69;
	background: radial-gradient(#ff6f69, #ff8b87);
}

.border{
	padding: 5px;
		background: linear-gradient(110deg, #ffeead 33%, rgba(0, 0, 0, 0) 33%), linear-gradient(110deg, #C5E7D7 34%, #88d8b0 34%);
	background-size: 400% 400%;
	height: 400px;
	background-position: 25% 50%;
	-webkit-animation: Gradient 15s ease infinite;
	-moz-animation: Gradient 5s ease infinite;
}
.inner-cutout{
	padding: 40px 0;
	display: block;
	background-color:#ff6f69;/*#ff6f69*/

	margin: 2%;
	padding-bottom: 40px;
	height: 350px;
	background: radial-gradient(#ff6f69, #ff8b87);
	 background-size: 300%;
	background-position:50% 50%;

}
.knockout {

	vertical-align: middle;
	text-align: center;
	font-family: 'Pacifico', cursive;
	font-size:50pt;
	color: blue;
	color: #fff;
	background: linear-gradient(110deg, #ffeead 33%, rgba(0, 0, 0, 0) 33%), linear-gradient(110deg, #C5E7D7 34%, #88d8b0 34%);
	background-size: 400%;
	 -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
}
.knockout{
		animation: Gradient 5s ease infinite;
		-webkit-animation: Gradient 15s ease infinite;
		-moz-animation: Gradient 5s ease infinite;
}

@-webkit-keyframes Gradient {
	0% {
		background-position: 30% 50%
	}
	50% {
		background-position: 25% 50%
	}
	100% {
		background-position: 30% 50%
	}

}



.main{
	width: 50%;
	height: 100%;
	margin-left: 25%;
	margin-right:40%;
	margin-top: 10%;
}


.pos{
  position: fixed;
  z-index: 1000;
  width: 100%;

}

html, body
{
    width: 100%;
    height: 100%;
}
body
{
  	background: rgb(31, 141, 214);
    width: 100%;
    height: 100%;
    background-attachment: fixed;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
			HttpSession session = request.getSession(false);
			String actionMessage = (String)session.getAttribute(Constants.ACTION_MESSAGE);
			if (actionMessage!= null) {
	%>
			<h3>Sign in error</h3>
	<% 
			}
	%>

 <div class="pos">
  <div class="topnav" id="myTopnav">
    <a href="#home" class="active">Home</a>
    <a href="#news">Banking</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>

    <a onclick="document.getElementById('id01').style.display='block'" style="width:auto" id="login">Employee Login</a>
	<a href="customerRegisteration" style="width:auto" id="login" >Customer Registration</a>
    <a onclick="document.getElementById('id02').style.display='block'" style="width:auto" id="login">Customer Login</a>


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

<div id="id01" class="modal">

  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="cms" method="post" autocomplete="off">
    <div class="container">
      <h1>Employee Login</h1>
      <label for="email"><b>Username</b></label>
      <input type="text" placeholder="Username" name="employee_username" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="employee_psw" required>

      <label>
        <input type="checkbox" checked="checked" name="employee_remember" style="margin-bottom:15px" required> <b>I am not a robot</b>
      </label>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn" name="typeOfLogin" value="employeeLogin">Login</button>
      </div>
    </div>
  </form>
</div>
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>



<div id="id02" class="modal">
  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="dashboard" method="post" autocomplete="off">
    <div class="container">
      <h1>Customer Login</h1>
      <label for="email"><b>Username</b></label>
      <input type="text" placeholder="Username" name="customer_username" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="customer_psw" required>
      <label>
        <input type="checkbox" checked="checked" name="customer_remember" style="margin-bottom:15px" required > I am not a robot</br>
      </label>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn" name="typeOfLogin" value="customerLogin">Login</button>
      </div>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

<div class="main">
	<div class = "border">
		<div class = "inner-cutout">
			<h1 class="knockout">Blitzkrieg <br> Bank</h1>
		</div>
	</div>
</div>
</div>
<div class="footer">
<%@include file="footer.jsp" %>
</div>
</body>
</html>
