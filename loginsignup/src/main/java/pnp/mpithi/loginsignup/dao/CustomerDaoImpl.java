package pnp.mpithi.loginsignup.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import pnp.mpithi.loginsignup.model.Customer;

public class CustomerDaoImpl implements CustomerDao   {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.openSession();
		Transaction transc = session.beginTransaction();
		
		if (customer != null){
			try {
				session.save(customer);
				transc.commit();
				session.close();
			} catch (Exception ex){
				transc.rollback();
				session.close();
				ex.printStackTrace();
			}
		}
		
	}

	@Override
	public Customer loginCustomer(Customer customer) {

		Session session = sessionFactory.openSession();
		
		Transaction transac = session.beginTransaction();
		
		String hql = "from pnp.mpithi.loginsignup.model.Customer as c where c.email=? and c.password=?";
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, customer.getEmail());
			query.setParameter(1, customer.getPassword());
			
			customer = (Customer)query.uniqueResult();
			
			transac.commit();
			session.close();
		} catch (Exception ex){
			transac.rollback();
			session.close();
			ex.printStackTrace();
		}
		
		return customer;			
				
	}

}
