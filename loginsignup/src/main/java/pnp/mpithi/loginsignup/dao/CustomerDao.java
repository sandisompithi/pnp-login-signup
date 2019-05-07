package pnp.mpithi.loginsignup.dao;

import pnp.mpithi.loginsignup.model.Customer;

public interface CustomerDao {

	public void saveCustomer(Customer customer);
	public Customer loginCustomer(Customer customer);
}
