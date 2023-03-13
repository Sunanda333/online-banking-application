package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppUtils {
public static boolean isValidUsername(final String username) {
return username.matches("^[a-zA-Z0-9]*$");
	
}
public static boolean isValidPassword(final String password) {
if(password.length()>=8 && password.contains("^[a-z]*$")&& password.contains("^[A-Z]*$")
&& password.contains("^[0-9]*$")&& password.contains("^[@!#$%^&*?()[]{}~,:]*$"))
	return true;
return false;
}
public static boolean isValidDate(final String date) {
final String formatString="yyyy-MM-dd";
try {
	final SimpleDateFormat format=new SimpleDateFormat(formatString);
	format.setLenient(false);
	format.parse(date);
}catch(final ParseException e) {
	return false;
}catch(final IllegalArgumentException e) {
	return false;
}
return true;
}
public static boolean isEmpty(final String param) {
final boolean error=false;
if(param==null||param.trim().length()<=0) {
	return true;
}
return error;
}
public static boolean isValidPhone(final String phone) {
	if(phone.matches("^[0-9]*$") && phone.length()==10) {
		return true;
		}
	return false;
}
public static boolean isValidPan(final String pan) {
if( pan.length()==10 && pan.substring(0,4).matches("^[A-Z]*$") &&
pan.substring(5,8).matches("^[0-9]*$") && pan.substring(9).matches("^[A-Z]*$")) {
	return true;
}
return false;
	
}

public static boolean isValidEmail(final String email) {
	int atpos=email.indexOf("@");
	int dotpos=email.lastIndexOf(".");
	if(atpos<1 || dotpos<atpos+2 ||dotpos+2>=email.length()) {
		return false;
	}
	return true;
}
public static boolean isValidCustomerId(final String id) {
 if(id.matches("^[0-9]*$") && id.length()==8) {
	 return true;
	 
 }
 return false;
	
}
public static boolean isValidAccountNo(final String accNo) {
	 if(accNo.matches("^[0-9]*$") && accNo.length()==12) {
		 return true;
		 
	 }
	 return false;
		
	}
}
