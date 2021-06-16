package com.mt.IMS.Service;

import java.util.List;

import com.mt.IMS.Entities.Customer;
import com.mt.IMS.Exception.InvalidIdException;

public interface CustomerService 
{

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(long customerId) throws InvalidIdException;

	public Customer addCustomers(Customer customers);

	public Customer updateCustomer(Customer customers) throws InvalidIdException;

	public String deleteCustomer(long orderId) throws InvalidIdException;
	
}
