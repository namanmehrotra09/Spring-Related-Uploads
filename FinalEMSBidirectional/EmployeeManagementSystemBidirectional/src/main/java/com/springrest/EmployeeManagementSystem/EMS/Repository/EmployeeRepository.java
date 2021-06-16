package com.springrest.EmployeeManagementSystem.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.EmployeeManagementSystem.EMS.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
