package com.mt.IMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.IMS.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
