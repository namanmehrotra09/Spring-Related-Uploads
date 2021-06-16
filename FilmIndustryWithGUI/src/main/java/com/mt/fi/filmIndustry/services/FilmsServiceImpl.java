package com.mt.fi.filmIndustry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.fi.filmIndustry.entities.Films;
import com.mt.fi.filmIndustry.exceptions.NameInvalidException;
import com.mt.fi.filmIndustry.repository.FilmsRepository;

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
	public Films getFilmById(int filmId) throws NameInvalidException
	{
		Films film = filmRepo.findById(filmId).orElseThrow(()-> new NameInvalidException("Film Not Found With Name : "+filmId));
		return film;
	}

	@Override
	public Films addFilm(Films films) 
	{
		log.info("Film added Successfully");
		return filmRepo.save(films);
	}

	@Override
	public Films updateFilm(Films films) throws NameInvalidException 
	{
		Films film = filmRepo.findById(films.getFilmId()).orElseThrow(()-> new NameInvalidException("Film Not Found With Name : "+films.getFilmId()));
		film.setRating(films.getRating());
		film.setBoxOfficeCollection(films.getBoxOfficeCollection());
		film.setFilmName(films.getFilmName());
		return filmRepo.save(film);
	}

	@Override
	public String deleteFilm(String filmName) throws NameInvalidException 
	{
		List<Films> filmList=filmRepo.findAll();
        boolean flag=false;

        for(Films film:filmList){
            if(film.getFilmName().equalsIgnoreCase(filmName)){
                flag=true;
                filmRepo.delete(film);
            }
        }
        if(flag){
            log.info("Film deleted successfully with name "+filmName);
            return "Film deleted successfully.";
        }else{
            String msg="";
                List<Films> filmList1= filmRepo.findAll();
                for(Films film:filmList1)
                    msg+=film;
                log.error("601","There doesn't exists any Film with Film name:"+filmName+"\n",msg);
                throw new NameInvalidException("There doesn't exists any Film with Film name:"+filmName);
        }
	}

}
