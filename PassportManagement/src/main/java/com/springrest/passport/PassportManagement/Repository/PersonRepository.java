package com.springrest.passport.PassportManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.passport.PassportManagement.Entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>
{

}
