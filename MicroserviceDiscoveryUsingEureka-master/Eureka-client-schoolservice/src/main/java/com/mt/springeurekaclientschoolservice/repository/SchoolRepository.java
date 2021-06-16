package com.mt.springeurekaclientschoolservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.springeurekaclientschoolservice.entities.School;


@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

	School findByName(String schoolName);

}
