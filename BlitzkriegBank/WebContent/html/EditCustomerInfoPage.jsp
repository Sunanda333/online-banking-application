<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
    
.footer {
   position:absolute;
   bottom:0;
   width:100%;
   height:60px; 
   background:#6cf;
}
</style>

</head>
<body>

<h2>Customer Details</h2>

<div class="container">
  <form action="editInfo" method="post">
    <div class="row">
      <div class="col-25">
        <label for="fname">First Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="fname" name="firstname" placeholder="Your name.." readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">Last Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="lname" name="lastname" placeholder="Your last name.." readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="pan">PAN Number</label>
      </div>
      <div class="col-75">
        <input type="text" id="pan" name="pan" placeholder="Your pan number.." readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="dob">Date of Birth</label>
      </div>
      <div class="col-75">
        <input type="text" id="dob" name="dob" placeholder="Your date of birth.." readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="pnum">Phone Number</label>
      </div>
      <div class="col-75">
        <input type="text" id="pnum" name="pnum" readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="employee_email">Email Address</label>
      </div>
      <div class="col-75">
        <input type="text" id="pemail" name="pemail" placeholder="xyz@domain.com" readonly>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="anum">Alternate Phone Number(Optional)</label>
      </div>
      <div class="col-75">
        <input type="text" id="anum" name="anum" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="employee_email">Alternate Email Address(Optional)</label>
      </div>
      <div class="col-75">
        <input type="text" id="aemail" name="aemail" placeholder="xyz@domain.com">
      </div>
    </div>
    
   
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form>
</div>
<div class="footer">
<%@include file="footer.jsp" %>
</div>

</body>
</html>
