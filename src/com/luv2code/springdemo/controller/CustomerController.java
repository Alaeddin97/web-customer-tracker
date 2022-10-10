package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// Inject the customer service
	@Autowired 
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get the customers from the DAO
		List<Customer>customers=customerService.getCustomers();
		// add these customers to the model
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer=new Customer("machin","machin","machin");
		theModel.addAttribute("customer", customer);
		return "showFormForAdd";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Model thModel,@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "showFormForAdd";
	}
}








