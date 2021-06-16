package com.mt.fi.filmIndustry.services;

import java.util.List;

import com.mt.fi.filmIndustry.entities.Films;
import com.mt.fi.filmIndustry.exceptions.NameInvalidException;

public interface FilmsService 
{

	public List<Films> getAllFilms();

	public Films getFilmById(int filmId) throws NameInvalidException;

	public Films addFilm(Films films) throws NameInvalidException;

	public Films updateFilm(Films films) throws NameInvalidException;

	public String deleteFilm(String filmName) throws NameInvalidException;
	
}
