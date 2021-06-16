package com.springrest.EmployeeManagementSystem.EMS.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.EmployeeManagementSystem.EMS.Entities.Employee;
import com.springrest.EmployeeManagementSystem.EMS.Exception.ResourceNotFoundException;
import com.springrest.EmployeeManagementSystem.EMS.Service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyController
{
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home page for Employee Management System";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		log.info("Getting the details of all the employees.....");
		return this.empService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long empID) throws ResourceNotFoundException
	{
		try 
		{
			log.info("Showing all the details of Employee by their ID"+empID);
			Employee emp = empService.getEmployeeById(empID);
			log.info("Showing all the details for ID"+empID);
			return ResponseEntity.ok().body(emp);
		} catch (Exception e) 
		{
			e.printStackTrace();
			throw new ResourceNotFoundException("Not found with ID"+empID);
		}
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee Emp)
	{
		log.info("Adding Employee Details");
		Employee emp = empService.addEmployee(Emp);
		log.info("Showing all the details after addition");
		return ResponseEntity.ok().body(emp);
	}
	
//	@PostMapping("/employees/office")
//	public ResponseEntity<Employee> addEmployeeOffice(@RequestBody Employee Emp)
//	{
//		Employee emp = empService.addEmployee(Emp);
//		return ResponseEntity.ok().body(emp);
//	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") long EmpID , @RequestBody Employee Emp) throws ResourceNotFoundException
	{
		try 
		{
			log.info("Calling update Employee method for Employee ID"+EmpID);
			Employee emp = this.empService.updateEmployee(EmpID,Emp);
			log.info("Showing all the details");
			return ResponseEntity.ok().body(emp);
		} catch (ResourceNotFoundException e) 
		{
			e.printStackTrace();
			throw new ResourceNotFoundException("Not found with ID "+EmpID);
		}
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value="id") long empID) throws ResourceNotFoundException
	{
		log.info("Calling delete Employee method for Employee ID "+empID);
		this.empService.deleteEmployee(empID);
		log.info("Deletion of "+empID+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/employees/sort")
	public ResponseEntity<List<Employee>> sortEmployees()
	{
		log.info("Sorting all the details of Employee by their name and if name is same then by their ID");
		List<Employee> employees = this.empService.getEmployees();
		List <Employee> employeesSortedList = employees.stream()
				.sorted(Comparator.comparing(Employee::getEname).thenComparing(Employee::getId)).collect(Collectors.toList());//ascending order
		log.info("Showing all the sorted details");
		return ResponseEntity.ok().body(employeesSortedList);
	}
}
