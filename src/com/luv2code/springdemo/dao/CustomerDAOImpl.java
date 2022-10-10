package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> listCustomers = new ArrayList<Customer>();
		// get the current HIBERNATE session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer c order by c.lastName", Customer.class);
		// return the list of customers
		listCustomers = query.getResultList();
		return listCustomers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		// save a customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerID) {
		Session currentSession = sessionFactory.getCurrentSession();
		// get customer
		Customer customer = currentSession.get(Customer.class, customerID);
		return customer;
	}

	@Override
	public void deleteCustomer(int customerID) {
		Session currentSession=sessionFactory.getCurrentSession();
		//get customer
		Customer customer=currentSession.get(Customer.class, customerID);
		// delete customer
		currentSession.delete(customer);
	}

}
