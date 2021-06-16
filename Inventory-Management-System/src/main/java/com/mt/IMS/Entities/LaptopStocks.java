package com.mt.IMS.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LaptopStocks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long laptopId;
	private String laptopName;
	private String laptopBrand;
	private int quantity;
	private float price;
	
	@ManyToOne
	private Orders laptopOrdered;

	public long getLaptopId() {
		return laptopId;
	}

	public LaptopStocks(long laptopId, String laptopName, String laptopBrand, int quantity, float price,
			Orders laptopOrdered) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
		this.laptopBrand = laptopBrand;
		this.quantity = quantity;
		this.price = price;
		this.laptopOrdered = laptopOrdered;
	}

	public LaptopStocks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setLaptopId(long laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Orders getLaptopOrdered() {
		return laptopOrdered;
	}

	public void setLaptopOrdered(Orders laptopOrdered) {
		this.laptopOrdered = laptopOrdered;
	}

	@Override
	public String toString() {
		return "LaptopStocks [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopBrand=" + laptopBrand
				+ ", quantity=" + quantity + ", price=" + price + ", laptopOrdered=" + laptopOrdered + "]";
	}
	
	
	
}
