package com.springrest.EmployeeManagementSystem.EMS.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Address")
public class EmployeeAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long addressID;
	
	private String addressType;
	
	@Column(name="city",nullable=false)
	private String city;
	
	private String street;
	
	private int pincode;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="Emp_ID")
//	private Employee employee;
}
