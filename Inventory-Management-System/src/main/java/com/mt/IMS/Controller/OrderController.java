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

import com.mt.IMS.Entities.Orders;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/ordersHome")
	public String home()
	{
		return "This is the Home Page to check the Orders";
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders()
	{
		return this.orderService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<String> getOrderById(@PathVariable(name = "id") long orderId) throws InvalidIdException
	{
		try 
		{
			log.info("Showing all the details of Directors by their Name"+orderId);
			Orders order = orderService.getOrderById(orderId);
			log.info("Showing all the details for Laptop : "+orderId);
			return ResponseEntity.ok().body("Displaying Details : "+order);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this name : "+orderId);
			throw new InvalidIdException("Not found with Id : "+orderId);
		}
	}
	
	@PostMapping("/orders")
	public ResponseEntity<String> addOrders(@RequestBody Orders orders)
	{
		Orders order = this.orderService.addOrders(orders);
		return ResponseEntity.ok().body("Laptop Is Added  :  "+order);
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<String> updateOrder(@RequestBody Orders orders) throws InvalidIdException
	{
		try 
		{
			log.info("Calling update Director method for Director's name : "+orders.getOrderId());
			Orders order = this.orderService.updateOrder(orders);
			log.info("Showing all the details");
			return ResponseEntity.ok().body("Updated Successfully : "+order);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this Id : "+orders.getOrderId());
			throw new InvalidIdException("The laptop with this Id "+orders.getOrderId()+" is not found");
		}
	}
	
	@DeleteMapping("orders/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable(value="id") long orderId) throws InvalidIdException 
	{
		log.info("Calling delete Laptop method for Laptop with Id : "+orderId);
		this.orderService.deleteOrder(orderId);
		log.info("Deletion of "+orderId+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
