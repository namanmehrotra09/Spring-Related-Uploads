package com.mt.fi.filmIndustry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.fi.filmIndustry.entities.Director;
import com.mt.fi.filmIndustry.entities.Films;
import com.mt.fi.filmIndustry.exceptions.InvalidDataException;
import com.mt.fi.filmIndustry.exceptions.NameInvalidException;
import com.mt.fi.filmIndustry.repository.DirectorsRepository;
import com.mt.fi.filmIndustry.repository.FilmsRepository;

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
	public Director updateDirector(Director directors) throws NameInvalidException, InvalidDataException 
	{
		Director updatedDirector = directorRepo.findById(directors.getDirectorName()).orElseThrow(()-> new NameInvalidException("Director Not Found With Name : "+directors.getDirectorName()));
		if((updatedDirector.getDirectorName().equalsIgnoreCase(directors.getDirectorName()))&&(updatedDirector.getAge() == directors.getAge())&&(updatedDirector.getAwardCount()==directors.getAwardCount()))
		{
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
	public String getDirectorsFilms(String directorName) 
	{
		String msg="";
        if(directorRepo.existsById(directorName))
        {
            msg+="Director founded with details:\n"+directorRepo.getOne(directorName);
            msg+="\n\nAll the lifetime work done by the director:\n";
            List<Films> filmList=filmRepo.findAll();
            for(Films film:filmList)
            {
                List<Director> directorList=film.getDirectedBy();
                for(Director director:directorList)
                {
                    if(director.getDirectorName().equalsIgnoreCase(directorName)==true){
                        msg+=film;
                    }
                }
            }
            log.info("Director "+directorName+" work succesfully displayed.");
            return msg;
        }
        log.warn("Trying to access invalid Director record with name: "+directorName);
        return "The Director with name:"+directorName+" does not exists in record.";
	}
}
