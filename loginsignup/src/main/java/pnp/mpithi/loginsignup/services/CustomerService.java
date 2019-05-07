package pnp.mpithi.loginsignup.services;

import pnp.mpithi.loginsignup.model.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	public Customer loginCustomer(Customer customer);
	
}
