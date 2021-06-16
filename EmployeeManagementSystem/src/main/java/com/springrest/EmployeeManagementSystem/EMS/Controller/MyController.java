package com.springrest.EmployeeManagementSystem.EMS.Controller;

import java.util.List;

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
		return this.empService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long empID)
	{
		Employee emp = null;
		try {
			emp = empService.getEmployeeById(empID);
			return ResponseEntity.ok().body(emp);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee Emp)
	{
		Employee emp = empService.addEmployee(Emp);
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
			Employee emp = this.empService.updateEmployee(EmpID,Emp);
			return ResponseEntity.ok().body(emp);
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value="id") long empID) throws ResourceNotFoundException
	{
		this.empService.deleteEmployee(empID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
