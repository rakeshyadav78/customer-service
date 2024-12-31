package com.tgd.custms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgd.custms.entity.Address;
import com.tgd.custms.entity.Customer;
import com.tgd.custms.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}

	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		return customerService.getCustomerById(customerId);
	}

	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);
	}

//	    @GetMapping("/{customerId}/orders")
//	    public List<Order> getCustomerOrders(@PathVariable Long customerId) {
//	        return customerService.getCustomerOrders(customerId);
//	    }

	@GetMapping("/{customerId}/addresses")
	public List<Address> getCustomerAddresses(@PathVariable Long customerId) {
		return customerService.getCustomerAddresses(customerId);
	}
}
