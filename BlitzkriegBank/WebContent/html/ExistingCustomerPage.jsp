<%@page import="com.blitzkrieg.utils.Constants"%>
<%@page import="com.blitzkrieg.model.Customer" %>
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
  <style><%@ include file="css/CustomerRegistrationHeader.css" %></style>
  <style><%@ include file="css/existing-cust.css" %></style>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Customers</title> 
    <style>
          tr:nth-child(even) {background: #F2F2F2}
tr:nth-child(odd) {background: #FAFAFA}


td{ width:200px; height:20px;border:1px solid black;}


tr.active{background:rgb(45, 62, 80);
color:white;
border:1px solid #5b88db;};
        </style>
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
				<a href="#logout" class="logout">Logout</a>
			
				
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
  
  <div class="outer">
  
      <h1 class="head">Existing Customers</h1> 
	  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
      <table id="myTable" border ="1" width="500" align="center" onclick="myFunction1()"> 
         <tr> 
          <th><b>CustomerId</b></th> 
          <th><b>CustomerName</b></th> 
         </tr> 
        <%ArrayList<Customer> customers =(ArrayList<Customer>)request.getAttribute(Constants.RESULTS); 
        for(Customer customer:customers){%> 
        
            <tr> 
                <td><%=customer.getCustomerID()%></td> 
                <td><%=customer.getCustomerName()%></td> 
                
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
        </div>
		<script>
			function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
    
                var table = document.getElementById('myTable');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                        
                         document.getElementById("id").value = this.cells[0].innerHTML;
                        
                     
                    };
                }
    
         </script>
		<script>
			$(document).on("click","tr", function(event) {

  $('tr').removeClass('active');  
  $(this).addClass('active');

});
			
function myFunction1(){
document.getElementById("button").style.display = "block";
}
</script>
<div class="cust-display">
      <form action="openAccount" method="POST">
        Customer Id:<input type="text" name="customerId" id="id"></div><br><br>
       <input type="submit" class="next" id="button" value="Next" style="display:none;">
      </form>
	<div class="footer">
<%@include file="footer.jsp" %>
</div>
</body> 

</html>
