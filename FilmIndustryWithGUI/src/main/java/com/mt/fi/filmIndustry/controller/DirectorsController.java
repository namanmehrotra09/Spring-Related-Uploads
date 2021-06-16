package com.mt.fi.filmIndustry.controller;

import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.fi.filmIndustry.entities.Director;
import com.mt.fi.filmIndustry.exceptions.InvalidDataException;
import com.mt.fi.filmIndustry.exceptions.NameInvalidException;
import com.mt.fi.filmIndustry.services.DirectorsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DirectorsController 
{
	@Autowired
	private DirectorsService directorService;
	
	@GetMapping("/directorshome")
	public String home()
	{
		return "This is the home page for Directors";
	}
	
	@GetMapping("/directors")
	public List<Director> getAllDirectors()
	{
		return this.directorService.getAllDirectors();
	}
	
	@GetMapping("/directors/{id}")
	public ResponseEntity<Director> getDirectorById(@PathVariable(value="id") String directorName) throws NameInvalidException
	{
		try 
		{
			log.info("Showing all the details of Directors by their Name"+directorName);
			Director director = directorService.getDirectorById(directorName);
			log.info("Showing all the details for Director"+directorName);
			return ResponseEntity.ok().body(director);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this name : "+directorName);
			throw new NameInvalidException("Not found with Name : "+directorName);
		}
	}
	
	@GetMapping("/directors/work/{directorName}")
    public ResponseEntity<String> displayDirectorWork(@PathVariable (value = "directorName") String directorName){
        String workDirector =  directorService.getDirectorsFilms(directorName);
        return new ResponseEntity<>(workDirector,HttpStatus.OK);
    }
	
	
	@PostMapping("/directors")
	public ResponseEntity<Director> addDirector(@RequestBody Director directors)
	{
		Director director = this.directorService.addDirector(directors);
		return ResponseEntity.ok().body(director);
	}
	
	@PutMapping("/directors")
	public ResponseEntity<Director> updateDirector(@RequestBody Director directors) throws InvalidNameException,InvalidDataException
	{
		try 
		{
			log.info("Calling update Director method for Director's name : "+directors.getDirectorName());
			Director director = this.directorService.updateDirector(directors);
			log.info("Showing all the details");
			return ResponseEntity.ok().body(director);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this name : "+directors.getDirectorName());
			throw new InvalidDataException("Not Valid Data for this name, please give updated inputs "+directors.getDirectorName());
		}
	}
	
	@DeleteMapping("directors/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value="id") String directorName) throws NameInvalidException
	{
		log.info("Calling delete Director method for Director with name : "+directorName);
		this.directorService.deleteDirector(directorName);
		log.info("Deletion of "+directorName+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
