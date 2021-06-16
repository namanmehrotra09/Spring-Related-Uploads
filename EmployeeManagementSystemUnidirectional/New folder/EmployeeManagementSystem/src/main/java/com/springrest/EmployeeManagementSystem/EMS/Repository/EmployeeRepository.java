package com.springrest.EmployeeManagementSystem.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.EmployeeManagementSystem.EMS.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
