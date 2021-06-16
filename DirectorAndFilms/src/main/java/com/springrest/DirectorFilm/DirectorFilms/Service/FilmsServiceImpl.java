package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;
import com.springrest.DirectorFilm.DirectorFilms.Repository.FilmsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FilmsServiceImpl implements FilmsService {

	@Autowired
	private FilmsRepository filmRepo;
	
	@Override
	public List<Films> getAllFilms() 
	{
		return filmRepo.findAll();
	}

	@Override
	public Films getFilmById(String filmName) throws NameInvalidException
	{
		Films film = filmRepo.findById(filmName).orElseThrow(()-> new NameInvalidException("Film Not Found With Name : "+filmName));
		return film;
	}

	@Override
	public Films addFilm(Films films) 
	{
		log.info("Track added Successfully");
		return filmRepo.save(films);
	}

	@Override
	public Films updateFilm(String filmName, Films films) throws NameInvalidException 
	{
		Films film = filmRepo.findById(filmName).orElseThrow(()-> new NameInvalidException("Film Not Found With Name : "+filmName));
		film.setRating(films.getRating());
		film.setBoxOfficeCollection(films.getBoxOfficeCollection());
		return filmRepo.save(film);
	}

	@Override
	public Films deleteFilm(String filmName) throws NameInvalidException 
	{
		Films film = filmRepo.findById(filmName).orElseThrow(()-> new NameInvalidException("Film Not Found With Name : "+filmName));
		filmRepo.delete(film);
		return film;
	}

}
