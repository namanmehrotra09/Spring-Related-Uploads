package com.springrest.EmployeeManagementSystem.EMS.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeAddress 
{
	@Id
	private byte addressID;
	
	private String addressType;
	
	@Column(name="city",nullable=false)
	private String city;
	
	private String street;
	
	private int pincode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Emp_ID")
	private Employee emp;
	
	public EmployeeAddress(byte addressID, String addressType, String city, String street, int pincode) {
		super();
		this.addressID = addressID;
		this.addressType = addressType;
		this.city = city;
		this.street = street;
		this.pincode = pincode;
	}
	public byte getAddressID() {
		return addressID;
	}
	public void setAddressID(byte addressID) {
		this.addressID = addressID;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public EmployeeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
