package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Director;
import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.InvalidDataException;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;
import com.springrest.DirectorFilm.DirectorFilms.Repository.DirectorsRepository;
import com.springrest.DirectorFilm.DirectorFilms.Repository.FilmsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DirectorsServiceImpl implements DirectorsService 
{
	
	@Autowired
	private DirectorsRepository directorRepo;
	
	@Autowired
	private FilmsRepository filmRepo;

	@Override
	public List<Director> getAllDirectors() 
	{
		return directorRepo.findAll();
	}

	@Override
	public Director getDirectorById(String directorName) throws NameInvalidException 
	{
		Director director = directorRepo.findById(directorName).orElseThrow(()-> new NameInvalidException("Not Found With Name : "+directorName));
		return director;
	}

	@Override
	public Director addDirector(Director directors) 
	{
		log.info("Track added Successfully");
		return directorRepo.save(directors);
	}

	

	@Override
	public String deleteDirector(String directorName) throws NameInvalidException 
	{
		Director director = directorRepo.findById(directorName).orElseThrow(()->new NameInvalidException("Director Not Found With Name : "+directorName+" So nothing to delete"));
		directorRepo.delete(director);
		return "The Director with name : "+directorName+" is deleted Successfully";
	}

	@Override
	public Director updateDirector(String directorName, Director directors) throws NameInvalidException, InvalidDataException 
	{
		Director updatedDirector = directorRepo.findById(directorName).orElseThrow(()-> new NameInvalidException("Director Not Found With Name : "+directorName));
		if((updatedDirector.getDirectorName().equalsIgnoreCase(directors.getDirectorName()))&&(updatedDirector.getAge() == directors.getAge())&&(updatedDirector.getAwardCount()==directors.getAwardCount()))
		{
			//System.out.println(directors);
			throw new InvalidDataException("Please Input Data other than already present to update the same");
		}
		else
		{
			updatedDirector.setAge(directors.getAge());
			updatedDirector.setAwardCount(directors.getAwardCount());
			return directorRepo.save(updatedDirector);
		}
	}
	
	@Override
	public List<Films> getDirectorsFilms(String directorName) 
	{
        List<Films> films=new ArrayList<>();
        for(Films film:filmRepo.findAll()){
            if(film.getDirectedBy().equals(directorName));
            {
                films.add(film);
            }
        }
        return films;
	}

}
