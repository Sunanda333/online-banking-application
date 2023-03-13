function validateFname(input) {
	document.getElementById('error5').innerHTML=" ";
	reg = /^[A-Za-z]+$/;
  if(input.value == "") {
    document.getElementById('error5').innerHTML="First name cannot be null";
    return false;
  }
  else if(input.value.match(reg)) {
    document.getElementById('error5').innerHTML=" ";
    return true;
  }
  else {
	  document.getElementById('error5').innerHTML="First name is invalid";
	  return false;
  }
}

function validateLname(inputtext) {
	document.getElementById('error6').innerHTML=" ";
	reg = /^[A-Za-z]+$/;
  if(inputtext.value == "") {
    document.getElementById('error6').innerHTML="Last name cannot be null";
    return false;
  }
  else if (input.value.match(reg)) {
    document.getElementById('error6').innerHTML=" ";
    return true;
  }
  else {
	  document.getElementById('error6').innerHTML="Last name invalid";
	    return false;
  }
}

function validateEmail(emailField){
	document.getElementById('error4').innerHTML=" ";
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if(emailField.value == "") {
          document.getElementById('error4').innerHTML="Email cannot be null";
          return false;
        }
        else if (reg.test(emailField.value) == false) {
            document.getElementById('error4').innerHTML="Email is invalid";
            return false;
        }
        else {
        document.getElementById('error4').innerHTML=" ";
        return true;
}
}

function validateAemail(emailField){
				document.getElementById('error7').innerHTML=" ";
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if(emailField.value == "") {
          document.getElementById('error7').innerHTML=" ";
          return true;
        }
        else if (reg.test(emailField.value) == false) {
            document.getElementById('error7').innerHTML="Email is invalid";
            return false;
        }
        else {
        document.getElementById('error7').innerHTML=" ";
        return true;
}
}

function phonenumber(inputtxt)
{
	document.getElementById('error3').innerHTML=" ";
  var phoneno = /^\d{10}$/;
  if(inputtxt.value == "") {
    document.getElementById('error3').innerHTML="Phone number cannot be null";
    return false;
  }
  else if(inputtxt.value.match(phoneno)) {
            document.getElementById('error3').innerHTML=" ";
            return true;
        }
      else {
        document.getElementById('error3').innerHTML="Phone number is invalid";
        return false;
        }
}

function phoneAnumber(inputtxt)
{
	document.getElementById('error8').innerHTML=" ";
  var phoneno = /^\d{10}$/;
  if(inputtxt.value == "") {
    document.getElementById('error8').innerHTML=" ";
    return true;
  }
  else if(inputtxt.value.match(phoneno)) {
            document.getElementById('error8').innerHTML=" ";
            return true;
        }
      else {
        document.getElementById('error8').innerHTML="Phone number is invalid";
        return false;
        }
}

function fnValidatePAN(pan_no)
{
	document.getElementById('error1').innerHTML=" ";
   if(pan_no.value == "") {
     document.getElementById('error1').innerHTML="Pan cannot be null";
     return false;
   }
 else if(pan_no.value != "") {
            PanNo = pan_no.value;
            var panPattern = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
            if (PanNo.search(panPattern) == -1) {
                document.getElementById('error1').innerHTML="Pan is invalid";
                pan_no.focus();
                // pan_no.value='';
                return false;
            }
            else {
              document.getElementById('error1').innerHTML=" ";
            return true;
        }
			}
}

function validatePassword(password) {
								document.getElementById("msg").innerHTML = " ";
                if (password.length === 0) {
                    document.getElementById("msg").innerHTML = "Password cannot be null";
                    return false;
                }
                var matchedCase = new Array();
                matchedCase.push("[$@$!%*#?&]");
                matchedCase.push("[A-Z]");
                matchedCase.push("[0-9]");
                matchedCase.push("[a-z]");

                var ctr = 0;
                for (var i = 0; i < matchedCase.length; i++) {
                    if (new RegExp(matchedCase[i]).test(password)) {
                        ctr++;
                    }
                }

                var color = "";
                var strength = "";
                switch (ctr) {
                    case 0:
                    case 1:
                    case 2:
                        strength = "Very Weak";
                        color = "red";
                        break;
                    case 3:
                        strength = "Medium";
                        color = "orange";
                        break;
                    case 4:
                        strength = "Strong";
                        color = "green";
                        break;
                }
                document.getElementById("msg").innerHTML = strength;
                document.getElementById("msg").style.color = color;
                return true;
}

function validatedate(inputText)
  {
    document.getElementById('error2').innerHTML=" ";
    var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    // Match the date format through regular expression
    if(inputText.value == "")
    {
      document.getElementById('error2').innerHTML="DOB cannot be null";
      return false;
  }
  else if(inputText.value.match(dateformat))
  {
  document.form1.text1.focus();
  //Test which seperator is used '/' or '-'
  var opera1 = inputText.value.split('/');
  var opera2 = inputText.value.split('-');
  lopera1 = opera1.length;
  lopera2 = opera2.length;
  // Extract the string into month, date and year
    if (lopera1>1)
  {
  var pdate = inputText.value.split('/');
  }
  else if (lopera2>1)
  {
  var pdate = inputText.value.split('-');
  }
  var dd = parseInt(pdate[0]);
  var mm  = parseInt(pdate[1]);
  var yy = parseInt(pdate[2]);
  // Create list of days of a month [assume there is no leap year by default]
  var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];
  if (mm==1 || mm>2)
  {
  if (dd>ListofDays[mm-1])
  {
  document.getElementById('error2').innerHTML="Date format is invalid";
  return false;
  }
  else {
      document.getElementById('error2').innerHTML=" ";
      return true;
  }
  }
  if (mm==2)
  {
  var lyear = false;
  if ( (!(yy % 4) && yy % 100) || !(yy % 400))
  {
  lyear = true;
  }
  if ((lyear==false) && (dd>=29))
  {
  document.getElementById('error2').innerHTML="Date format is invalid";
  return false;
  }
  else
  {
    document.getElementById('error2').innerHTML=" ";
    return true;
  }
  if ((lyear==true) && (dd>29))
  {
  document.getElementById('error2').innerHTML="Date format is invalid";
  return false;
  }
  else {
    document.getElementById('error2').innerHTML=" ";
    return true;
  }
  }
  }
  else
  {
  document.getElementById('error2').innerHTML="Date format is invalid ";
  document.form1.text1.focus();
  return false;
  }
  }

  function validateAddress(input)
  {
		document.getElementById('error9').innerHTML=" ";
    if(input.value == "") {
      document.getElementById('error9').innerHTML="Address cannot be null";
      return false;
    }
    else {
      document.getElementById('error9').innerHTML=" ";
      return true;
    }
  }

  function validateInitialDeposit(input)
  {
		document.getElementById('error11').innerHTML=" ";
	var reg = /^[0-9]+$/;
    if(input.value == "")
    {
      document.getElementById('error11').innerHTML="Initial Deposit cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
			if(parseInt(input.value) > 20000) {
      document.getElementById('error11').innerHTML=" ";
      return true;
		}
		else {
			document.getElementById('error11').innerHTML=" Minimum Balance cannot be lesser than minimum balance";
			return true;
		}
    }
    else {
    	document.getElementById('error11').innerHTML="Initial Deposit is invalid";
        return false;
    }
  }

  function validateMinBalance(input)
  {
		document.getElementById('error12').innerHTML=" ";
	var reg = /^[0-9]+$/;
    if(input.value == "")
    {
      document.getElementById('error12').innerHTML="Minimum Balance cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
			if(parseInt(input.value) > 20000) {
      document.getElementById('error12').innerHTML=" ";
      return true;
		}
		else {
			document.getElementById('error12').innerHTML=" Minimum Balance cannot be lesser than 20,000";
			return true;
		}
    }
    else {
    	document.getElementById('error12').innerHTML="Minimum Balance is invalid";
        return false;
    }
  }

  function validateOverdraft(input)
  {
		document.getElementById('error13').innerHTML=" ";
	var reg = /^[0-9]+$/;
  if(input.value.match(reg))
    {
      document.getElementById('error13').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error13').innerHTML="Overdraft is invalid";
        return false;
    }
  }

  function validateCity(input)
  {
		document.getElementById('error14').innerHTML=" ";
	  var reg = /^[A-Za-z]+$/;
    if(input.value == "")
    {
      document.getElementById('error14').innerHTML="City cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error14').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error14').innerHTML="City is not valid";
        return false;
    }
  }

  function validateState(input)
  {
		document.getElementById('error15').innerHTML=" ";
	  var reg = /^[A-Za-z]+$/;
    if(input.value == "")
    {
      document.getElementById('error15').innerHTML="State cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error15').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error15').innerHTML="State is invalid";
        return false;
    }
  }

  function validatePin(input)
  {
		document.getElementById('error16').innerHTML=" ";
	var reg = /^[0-9]+$/;
    if(input.value == "")
    {
      document.getElementById('error16').innerHTML="Pin cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error16').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error16').innerHTML="Pin is invalid";
        return false;
    }
  }

  function validateCust(input)
  {
		document.getElementById('error17').innerHTML=" ";
	var reg = /^([0-9a-zA-Z]){8}$/;
    if(input.value == "")
    {
      document.getElementById('error17').innerHTML="Customer ID cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error17').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error17').innerHTML="Customer ID is invalid";
        return false;
    }
  }

  function validateName(input)
  {
		document.getElementById('error18').innerHTML=" ";
	var reg = /^[A-Za-z]+$/;
    if(input.value == "")
    {
      document.getElementById('error18').innerHTML="Name cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error18').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error18').innerHTML="Name is invalid";
        return false;
    }
  }

  function validateUsername(input)
  {
		document.getElementById('error19').innerHTML=" ";
	var reg = /^[0-9a-zA-Z]+$/;
    if(input.value == "")
    {
      document.getElementById('error19').innerHTML="Username cannot be null";
      return false;
    }
    else if(input.value.match(reg))
    {
      document.getElementById('error19').innerHTML=" ";
      return true;
    }
    else {
    	document.getElementById('error19').innerHTML="Username is invalid";
        return false;
    }
  }

function showDiv() {
   document.getElementById('welcomeDiv').style.display = "block";
		document.getElementById('addCust').style.display = "none";
}
