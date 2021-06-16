package com.springrest.EmployeeManagementSystem.EMS.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{
	@Id
	private long id;
	private String ename;
	private String gender;
	private byte age;
	private long salary;
	private String department;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EmployeeAddress> employeeAddress;
}
