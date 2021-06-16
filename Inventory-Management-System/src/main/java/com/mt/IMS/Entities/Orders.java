package com.mt.IMS.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private int orderQuantity;
	
	@ManyToOne
	private Customer customer;
	
	
	@OneToMany(mappedBy = "laptopOrdered")
	private List<LaptopStocks> laptops;


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public int getOrderQuantity() {
		return orderQuantity;
	}


	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orders(long orderId, int orderQuantity, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderQuantity=" + orderQuantity + ", customer=" + customer + "]";
	}
	
	
}
