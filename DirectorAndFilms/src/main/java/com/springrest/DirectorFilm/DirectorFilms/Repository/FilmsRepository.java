package com.springrest.DirectorFilm.DirectorFilms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;

public interface FilmsRepository extends JpaRepository<Films, String>{

}
