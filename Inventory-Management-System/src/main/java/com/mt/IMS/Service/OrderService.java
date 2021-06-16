package com.mt.IMS.Service;

import java.util.List;

import com.mt.IMS.Entities.Orders;
import com.mt.IMS.Exception.InvalidIdException;

public interface OrderService 
{

	public List<Orders> getAllOrders();

	public Orders getOrderById(long orderId) throws InvalidIdException;

	public Orders addOrders(Orders orders);

	public Orders updateOrder(Orders orders) throws InvalidIdException;

	public String deleteOrder(long orderId) throws InvalidIdException;

}
