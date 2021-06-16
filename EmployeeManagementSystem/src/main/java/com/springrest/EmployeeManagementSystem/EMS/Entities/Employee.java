package com.springrest.EmployeeManagementSystem.EMS.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee 
{
	@Id
	private long id;
	private String ename;
	private String gender;
	private byte age;
	private long salary;
	private String department;
	
	@OneToMany(mappedBy = "emp", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EmployeeAddress> address;
	
	public List<EmployeeAddress> getAddress() {
		return address;
	}
	public void setAddress(List<EmployeeAddress> address) {
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Employee(long id, String ename, String gender, byte age, long salary, String department,
			List<EmployeeAddress> address) {
		super();
		this.id = id;
		this.ename = ename;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.department = department;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", gender=" + gender + ", age=" + age + ", salary=" + salary
				+ ", department=" + department + ", address=" + address + "]";
	}	
}
