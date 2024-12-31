package com.tgd.custms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgd.custms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
