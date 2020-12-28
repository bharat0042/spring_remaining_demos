package com.bharat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.entity.Customer;
import com.bharat.exceptions.CustomerNotFoundException;
import com.bharat.service.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		List<Customer> list = customerService.getCustomers();
		if(list == null) {
			throw new CustomerNotFoundException("Customers not found");
		}
		return list;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer with id : " + id + " not found") ;
		}
		return customer;
	}
	
	
	@PostMapping("/customers")
	public List<Customer> saveCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customerService.getCustomers();
	}
	
	@PutMapping("/customers")
	public List<Customer> updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customerService.getCustomers();
	}
	
	@DeleteMapping("/customers/{id}")
	public List<Customer> deleteCustomer(@PathVariable int id) {
		Customer theCustomer = customerService.getCustomer(id);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer with id : " + id + " not found");
		}
		customerService.deleteCustomer(id);
		return customerService.getCustomers();
	}
}
