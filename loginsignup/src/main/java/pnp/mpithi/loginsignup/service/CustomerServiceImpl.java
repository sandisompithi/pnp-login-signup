package pnp.mpithi.loginsignup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnp.mpithi.loginsignup.dao.CustomerDao;
import pnp.mpithi.loginsignup.model.Customer;
import pnp.mpithi.loginsignup.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer validateCustomerCredential(String email, String password) {
		
		Customer customer = getCustomerDao().getCustomerDetailsByEmailAndPassword(email, password);
		
		return customer;
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		
		boolean isSignUp = false;
		
		boolean createCustomer = getCustomerDao().createCustomer(customer);
		
		if (createCustomer)
			isSignUp = true;
		
		return isSignUp;
	}

	

}
