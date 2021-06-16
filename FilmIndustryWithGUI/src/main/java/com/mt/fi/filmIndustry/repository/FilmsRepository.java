package com.mt.fi.filmIndustry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.fi.filmIndustry.entities.Films;

public interface FilmsRepository extends JpaRepository<Films, Integer>{

}
