package com.mt.fi.filmIndustry.services;

import java.util.List;

import com.mt.fi.filmIndustry.entities.Director;
import com.mt.fi.filmIndustry.exceptions.InvalidDataException;
import com.mt.fi.filmIndustry.exceptions.NameInvalidException;

public interface DirectorsService 
{
	public List<Director> getAllDirectors();

	public Director getDirectorById(String directorName) throws NameInvalidException;

	public Director addDirector(Director directors);

	public String deleteDirector(String directorName) throws NameInvalidException;

	public Director updateDirector(Director directors) throws NameInvalidException, InvalidDataException;

	public String getDirectorsFilms(String directorName);
	
}
