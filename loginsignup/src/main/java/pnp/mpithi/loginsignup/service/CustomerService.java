package pnp.mpithi.loginsignup.service;

import pnp.mpithi.loginsignup.model.Customer;

public interface CustomerService {

	public abstract Customer validateCustomerCredential(String email,	String password);
	public abstract boolean registerCustomer(Customer customer);
	
}
