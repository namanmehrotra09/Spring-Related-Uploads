package com.mt.IMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.IMS.Entities.Orders;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Repository.OrdersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrdersRepository orderRepo;

	@Override
	public List<Orders> getAllOrders() 
	{
		return orderRepo.findAll();
	}

	@Override
	public Orders getOrderById(long orderId) throws InvalidIdException 
	{
		Orders order = orderRepo.findById(orderId).orElseThrow(()-> new InvalidIdException("Not Found With Id : "+orderId));
		return order;
	}

	@Override
	public Orders addOrders(Orders orders) 
	{
		log.info("Order added Successfully with Id : "+orders.getOrderId());
		return orderRepo.save(orders);
	}

	@Override
	public Orders updateOrder(Orders orders) throws InvalidIdException 
	{
		Orders order = orderRepo.findById(orders.getOrderId()).orElseThrow(()-> new InvalidIdException("Not Found With Name : "+orders.getOrderId()));
		order.setOrderQuantity(orders.getOrderQuantity());
		return orderRepo.save(order);
	}

	@Override
	public String deleteOrder(long orderId) throws InvalidIdException 
	{
		Orders order = orderRepo.findById(orderId).orElseThrow(()->new InvalidIdException("Director Not Found With ID : "+orderId+" So nothing to delete"));
		orderRepo.delete(order);
		return "The Laptop with Id : "+orderId+" is deleted Successfully";
	}

}
