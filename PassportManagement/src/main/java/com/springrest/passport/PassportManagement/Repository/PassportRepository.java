package com.springrest.passport.PassportManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.passport.PassportManagement.Entities.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> 
{

}
