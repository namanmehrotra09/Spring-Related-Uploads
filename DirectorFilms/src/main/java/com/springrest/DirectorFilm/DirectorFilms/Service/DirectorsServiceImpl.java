package com.springrest.DirectorFilm.DirectorFilms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Director;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.InvalidDataException;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;
import com.springrest.DirectorFilm.DirectorFilms.Repository.DirectorsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DirectorsServiceImpl implements DirectorsService 
{
	
	@Autowired
	private DirectorsRepository directorRepo;

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
		updatedDirector.setAge(directors.getAge());
		updatedDirector.setAwardCount(directors.getAwardCount());
		if(updatedDirector == directors)
		{
			System.out.println(directors);
			throw new InvalidDataException("Please Input Data other than already present to update the same");
		}
		else
		{
			return directorRepo.save(updatedDirector);
		}
	}

}
