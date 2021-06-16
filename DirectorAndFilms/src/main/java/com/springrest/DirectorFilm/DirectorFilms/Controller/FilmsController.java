package com.springrest.DirectorFilm.DirectorFilms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.DirectorFilm.DirectorFilms.Entities.Films;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;
import com.springrest.DirectorFilm.DirectorFilms.Service.FilmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FilmsController 
{
	@Autowired
	private FilmsService filmService;
	
	@GetMapping("/filmshome")
	public String home()
	{
		return "This is the home page for Films";
	}
	
	@GetMapping("/films")
	public List<Films> getAllFilms()
	{
		return this.filmService.getAllFilms();
	}
	
	@GetMapping("/films/{id}")
	public ResponseEntity<Films> getFilmById(@PathVariable(value="id") String filmName) throws NameInvalidException 
	{
		try 
		{
			log.info("Showing all the details of Films by their ID : "+filmName);
			Films film = filmService.getFilmById(filmName);
			log.info("Showing all the details for Film"+filmName);
			return ResponseEntity.ok().body(film);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this ID : "+filmName);
			throw new NameInvalidException("Not found with ID : "+filmName);
		}
	}
	
	@PostMapping("/films")
	public ResponseEntity<Films> addFilm(@RequestBody Films films) throws NameInvalidException
	{
		try {
			Films film = this.filmService.addFilm(films);
			return ResponseEntity.ok().body(film);
		} catch (Exception e) {
			e.getMessage();
			throw new NameInvalidException("Not found with the provided Director Name");
		}
	}
	
	@PutMapping("/films/{id}")
	public ResponseEntity<Films> updateFilm(@PathVariable(value="id") String filmName, @RequestBody Films films) throws NameInvalidException
	{
		try 
		{
			log.info("Calling update Film method for Film's ID : "+filmName);
			Films film = this.filmService.updateFilm(filmName,films);
			log.info("Showing all the details");
			return ResponseEntity.ok().body(film);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this ID : "+filmName);
			throw new NameInvalidException("Not Found for this ID : "+filmName);
		}
	}
	
	@DeleteMapping("films/{id}")
	public ResponseEntity<Films> deleteEmployee(@PathVariable(value="id") String filmName) throws NameInvalidException
	{
		log.info("Calling delete Film method for Film with this ID  : "+filmName);
		Films film = this.filmService.deleteFilm(filmName);
		log.info("Deletion of "+filmName+" is successful");
		return ResponseEntity.ok().body(film);
	}

}
