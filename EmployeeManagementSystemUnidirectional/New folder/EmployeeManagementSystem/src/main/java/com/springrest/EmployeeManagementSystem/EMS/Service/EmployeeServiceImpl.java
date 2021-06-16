package com.springrest.EmployeeManagementSystem.EMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.EmployeeManagementSystem.EMS.Entities.Employee;
import com.springrest.EmployeeManagementSystem.EMS.Exception.ResourceNotFoundException;
import com.springrest.EmployeeManagementSystem.EMS.Repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getEmployees() 
	{
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long empID) throws ResourceNotFoundException 
	{
		log.info("Getting the employee Details by id"+empID);
		Employee emp = empRepo.findById(empID).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found : "+empID));
		log.info("Returning error if found else returning the emp details");
		return emp;
	}

	@Override
	public Employee addEmployee(Employee Emp) 
	{
		return empRepo.save(Emp);
	}

	@Override
	public Employee updateEmployee(long empID, Employee Emp) throws ResourceNotFoundException 
	{
		Employee emp = empRepo.findById(empID).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found : "+empID));
		emp.setEname(Emp.getEname());
		emp.setAge(Emp.getAge());
		emp.setDepartment(Emp.getDepartment());
		emp.setGender(Emp.getGender());
		emp.setSalary(Emp.getSalary());
		return empRepo.save(emp);
	}

	@Override
	public void deleteEmployee(long EmpID) throws ResourceNotFoundException
	{
		Employee emp = empRepo.findById(EmpID).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found : "+EmpID));
		empRepo.delete(emp);
	}
}
