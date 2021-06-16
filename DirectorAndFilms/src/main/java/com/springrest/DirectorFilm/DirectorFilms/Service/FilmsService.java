package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.List;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;

public interface FilmsService 
{

	public List<Films> getAllFilms();

	public Films getFilmById(String filmName) throws NameInvalidException;

	public Films addFilm(Films films) throws NameInvalidException;

	public Films updateFilm(String filmName, Films films) throws NameInvalidException;

	public Films deleteFilm(String filmName) throws NameInvalidException;
	
}
