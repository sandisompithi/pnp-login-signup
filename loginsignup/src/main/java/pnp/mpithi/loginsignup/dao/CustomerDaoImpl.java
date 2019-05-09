package pnp.mpithi.loginsignup.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pnp.mpithi.loginsignup.dao.CustomerDao;
import pnp.mpithi.loginsignup.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernatetemplate() {
		return hibernateTemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean createCustomer(Customer customer) {
		
		int id = (Integer)hibernateTemplate.save(customer);
		
		if (id > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Customer getCustomerDetailsByEmailAndPassword(String email, String password) {

		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Customer.class);
		
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		
		List<Customer> findByCriteria = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria);
		
		if(findByCriteria !=null && findByCriteria.size() > 0){
			return findByCriteria.get(0);
		} else {
			return null;
		}
	}

}
