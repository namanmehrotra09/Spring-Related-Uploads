package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.List;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;

public interface FilmsService 
{

	public List<Films> getAllFilms();

	public Films getFilmById(int filmId) throws NameInvalidException;

	public Films addFilm(Films films);

	public Films updateFilm(int filmId, Films films) throws NameInvalidException;

	public Films deleteFilm(int filmId) throws NameInvalidException;
	
}
