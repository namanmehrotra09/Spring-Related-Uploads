package com.springrest.EmployeeManagementSystem.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.EmployeeManagementSystem.EMS.Entities.EmployeeAddress;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long>{

}
