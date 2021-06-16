package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.List;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Director;
import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.InvalidDataException;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;

public interface DirectorsService 
{
	public List<Director> getAllDirectors();

	public Director getDirectorById(String directorName) throws NameInvalidException;

	public Director addDirector(Director directors);

	public String deleteDirector(String directorName) throws NameInvalidException;

	public Director updateDirector(String directorName, Director directors) throws NameInvalidException, InvalidDataException;

	public List<Films> getDirectorsFilms(String directorName);
	
}
