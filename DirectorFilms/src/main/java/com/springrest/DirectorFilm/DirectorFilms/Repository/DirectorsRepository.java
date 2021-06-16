package com.springrest.DirectorFilm.DirectorFilms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Director;

public interface DirectorsRepository extends JpaRepository<Director, String>{

}
