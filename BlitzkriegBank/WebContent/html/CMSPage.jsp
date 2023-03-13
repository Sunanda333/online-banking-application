<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Management System</title>
	<style><%@ include file="css/CustomerRegistrationHeader.css" %></style>
	<style><%@ include file="css/cms.css"%></style>
</head>

<body>
	<%
		String user=(String)session.getAttribute("user");
		System.out.println(user);
		if(user==null)
			response.sendRedirect("/BlitzkriegBank");
	%>
		<div class="topnav" id="myTopnav">
				<a href="#home" class="active">Home</a>
				<a href="#news">Banking</a>
				<a href="#contact">Contact</a>
				<a href="#about">About</a>
				<a href="logout" class="logout">Logout</a>
			
				
				<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <div class="me-icon"></div>
	<div class="me-icon"></div>
	<div class="me-icon"></div>
      <i class="fa fa-bars"></i>
    </a>
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

<h1 class="head">Customer Management System</h1>


<div class="linkButton">
<a onclick="document.getElementById('id1').style.display='block'" style="width:auto">Open Account</a>
</div>
<div id="id1" class="modal">
	
  <span onclick="document.getElementById('id1').style.display='none'" class="close" title="Close Modal">&times;</span>
  <div class="modal-content">
    <div class="container">
	  <div class="clearfix">
		<div class="existingCustomer">
        <a href="existingCustomer" >Existing Customer</a>
		</div>
		<div class="newCustomer"><a href="openAccount"   >Register New Customer</a>
		</div>
		</div>
    </div>
  </div>
</div>
<script>
// Get the modal
var modal = document.getElementById('id1');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
<div class="footer">
<%@include file="footer.jsp" %>
</div>

</body>
</html>
