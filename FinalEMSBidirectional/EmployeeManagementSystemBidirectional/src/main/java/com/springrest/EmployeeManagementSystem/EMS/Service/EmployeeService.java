package com.springrest.EmployeeManagementSystem.EMS.Service;

import java.util.List;

import com.springrest.EmployeeManagementSystem.EMS.Entities.Employee;
import com.springrest.EmployeeManagementSystem.EMS.Exception.ResourceNotFoundException;

public interface EmployeeService 
{
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(long empID) throws ResourceNotFoundException;
	
	public Employee addEmployee(Employee Emp);
	
	public Employee updateEmployee(long empID, Employee Emp) throws ResourceNotFoundException;
	
	public void deleteEmployee(long EmpID) throws ResourceNotFoundException;
}
