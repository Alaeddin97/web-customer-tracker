package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		List<Customer>customers=customerDAO.getCustomers();
		return customers;
	}
	
	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

}
