package com.mt.IMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.IMS.Entities.Customer;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public List<Customer> getAllCustomers() 
	{
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) throws InvalidIdException 
	{
		Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new InvalidIdException("Not Found With Id : "+customerId));
		return customer;
	}

	@Override
	public Customer addCustomers(Customer customers) 
	{
		log.info("Customer added Successfully with Id : "+customers.getCustomerId());
		return customerRepo.save(customers);
	}

	@Override
	public Customer updateCustomer(Customer customers) throws InvalidIdException 
	{
		Customer customer = customerRepo.findById(customers.getCustomerId()).orElseThrow(()-> new InvalidIdException("Not Found With Name : "+customers.getCustomerId()));
		customer.setCustomerName(customers.getCustomerName());
		customer.setContact(customers.getContact());
		customer.setAddress(customers.getAddress());
		return customerRepo.save(customer);
	}

	@Override
	public String deleteCustomer(long customerId) throws InvalidIdException 
	{
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new InvalidIdException("Director Not Found With ID : "+customerId+" So nothing to delete"));
		customerRepo.delete(customer);
		return "The Laptop with Id : "+customerId+" is deleted Successfully";
	}

}
