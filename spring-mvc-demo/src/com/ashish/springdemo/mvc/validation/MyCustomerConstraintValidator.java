package com.ashish.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomerConstraintValidator 
	implements ConstraintValidator<MyCustomAnnotation , String> {
	
	private String myPrefixValue;
	@Override
	public void initialize(MyCustomAnnotation theCustomAnnotation) {
		myPrefixValue = theCustomAnnotation.value();
	}

	@Override
	public boolean isValid(String userCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		if(userCode != null) {
			 result = userCode.startsWith(myPrefixValue);
		}else {
			
			result = true;
		}
 
			
		return result;
	}

}
