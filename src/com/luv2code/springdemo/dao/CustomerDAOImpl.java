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
	//@Transactional
	public List<Customer> getCustomers() {
		List<Customer> listCustomers = new ArrayList<Customer>();
		// get the current HIBERNATE session
		Session currentSession= sessionFactory.getCurrentSession();
		//create a query 
		Query<Customer>query= currentSession.createQuery("from Customer", Customer.class);
		// return the list of customers
		listCustomers=query.getResultList();
		return listCustomers;
	}

}






