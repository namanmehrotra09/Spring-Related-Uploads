package com.mt.IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.IMS.Entities.Customer;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService custService;
	
	@GetMapping("/customersHome")
	public String home()
	{
		return "This is the Home Page to see the Customers";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return this.custService.getAllCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<String> getCustomerById(@PathVariable(name = "id") long customerId) throws InvalidIdException
	{
		try 
		{
			log.info("Showing all the details of Directors by their Name"+customerId);
			Customer customer = custService.getCustomerById(customerId);
			log.info("Showing all the details for Laptop : "+customerId);
			return ResponseEntity.ok().body("Displaying Details : "+customer);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this name : "+customerId);
			throw new InvalidIdException("Not found with Id : "+customerId);
		}
	}
	
	@PostMapping("/customers")
	public ResponseEntity<String> addCustomers(@RequestBody Customer customers)
	{
		Customer customer = this.custService.addCustomers(customers);
		return ResponseEntity.ok().body("Laptop Is Added  :  "+customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customers) throws InvalidIdException
	{
		try 
		{
			log.info("Calling update Director method for Director's name : "+customers.getCustomerId());
			Customer customer = this.custService.updateCustomer(customers);
			log.info("Showing all the details");
			return ResponseEntity.ok().body("Updated Successfully : "+customer);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this Id : "+customers.getCustomerId());
			throw new InvalidIdException("The laptop with this Id "+customers.getCustomerId()+" is not found");
		}
	}
	
	@DeleteMapping("customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable(value="id") long customerId) throws InvalidIdException 
	{
		log.info("Calling delete Laptop method for Laptop with Id : "+customerId);
		this.custService.deleteCustomer(customerId);
		log.info("Deletion of "+customerId+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
