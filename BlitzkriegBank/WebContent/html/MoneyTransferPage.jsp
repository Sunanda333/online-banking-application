<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	<%@ include file="css/customer-sign.css"%>
</style>

</head>
<body>

<h1>Money Transfer</h1>
<div class="container">
  <form action="/action_page.php">
 <div class="row">
      <div class="col-25"><label for="account">From Account </label>
      </div>
	  <div class="col-75">
	<section class="main">
				<div class="wrapper-demo">
					<div id="dd" class="wrapper-dropdown-5" tabindex="1">Account Name
						<ul class="dropdown">
							<li><a href="#"><i class="icon-user"></i>Account 1</a></li>
							<li><a href="#"><i class="icon-cog"></i>Account 2</a></li>
						</ul>
					</div>
				​</div>
			</section>
	 </div>
	 
	 <div class="row">
      <div class="col-25">
        <label for="deposit-amount">To Account</label>
      </div>
      <div class="col-75">
        <input type="text" id="to-account" name="to-account" placeholder="account number">
      </div>
    </div>
	
	<div class="row">
      <div class="col-25">
        <label for="amount-transfer">Amount</label>
      </div>
      <div class="col-75">
        <input type="text" id="transfer" name="transfer" placeholder="Ex - 10,000 INR">
      </div>
    </div>
	
	<div class="row">
      <input type="submit" value="Send">
    </div>
	 </div>
	 
	 </form>
	 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript">

	
	

			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-5').removeClass('active');
				});

			});

		</script>

<div class="footer">
<%@include file="footer.jsp" %>
</div>

</body>
</html>
