package com.bitwise.login;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bitwise.login.LoginBean;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return  LoginBean.class.equals(clazz);
	}

	@Override
	public  void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		
		LoginBean login = (LoginBean) obj;  
		  if (login.getUserName() == null || login.getUserName().length() == 0) {
		  errors.rejectValue("userName","error.empty.field", "Please Enter User Name");
		  }
		  else if (!login.getUserName().equals("tejasvi")) {
			  errors.rejectValue("userName", "unknown.user", "Unknown User");
		  }
		  if (login.getPassword() == null || login.getPassword().length() == 0) {
		  errors.rejectValue("password","error.empty.field", "Please Enter Password");
		  } 
		  else if (!login.getPassword().equals("tej")) {
		  errors.rejectValue("password", "wrong.password", "Wrong Password");
		  }
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "user name is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "password is required.");
       

		
	  }
	
		
	

}