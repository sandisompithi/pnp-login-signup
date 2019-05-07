package pnp.mpithi.loginsignup.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pnp.mpithi.loginsignup.model.Customer;

public class CustomerValidation implements Validator {

	public boolean supports(Class<?>arg0){
	
		return Customer.class.equals(arg0);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1){
		
	}

	
}
