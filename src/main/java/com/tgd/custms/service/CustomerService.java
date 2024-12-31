package com.tgd.custms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgd.custms.entity.Address;
import com.tgd.custms.entity.Customer;
import com.tgd.custms.repository.AddressRepository;
import com.tgd.custms.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

	public Customer getCustomerById(Long id) {
		log.debug("fetching data for customer Id : {}", id);
		Customer customer = customerRepository.findById(id).orElse(null);
		log.debug("cusotmer data : {}", customer.getId());
		return customer;
	}

//    public List<Order> getCustomerOrders(Long customerId) {
//        return orderRepository.findByCustomerId(customerId);
//    }

    public List<Address> getCustomerAddresses(Long customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        if (customerRepository.existsById(customerId)) {
            updatedCustomer.setId(customerId);
            return customerRepository.save(updatedCustomer);
        }
        return null;
    }
}
