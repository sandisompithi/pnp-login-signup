package pnp.mpithi.loginsignup.dao;

import pnp.mpithi.loginsignup.model.Customer;

public interface CustomerDao {

	public abstract boolean createCustomer(Customer customer);
	public Customer getCustomerDetailsByEmailAndPassword(String email,String password);
	
}
