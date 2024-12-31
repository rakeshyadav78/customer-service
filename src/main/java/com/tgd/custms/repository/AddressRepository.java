package com.tgd.custms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgd.custms.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

    List<Address> findByCustomerId(Long customerId);
}
