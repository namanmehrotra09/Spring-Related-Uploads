package com.springrest.DirectorFilm.DirectorFilms.Controller;

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
	public ResponseEntity<Films> getFilmById(@PathVariable(value="id") int filmId) throws InvalidNameException 
	{
		try 
		{
			log.info("Showing all the details of Films by their ID : "+filmId);
			Films film = filmService.getFilmById(filmId);
			log.info("Showing all the details for Film"+filmId);
			return ResponseEntity.ok().body(film);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this ID : "+filmId);
			throw new InvalidNameException("Not found with ID : "+filmId);
		}
	}
	
	@PostMapping("/films")
	public ResponseEntity<Films> addFilm(@RequestBody Films films)
	{
		Films film = this.filmService.addFilm(films);
		return ResponseEntity.ok().body(film);
	}
	
	@PutMapping("/films/{id}")
	public ResponseEntity<Films> updateFilm(@PathVariable(value="id") int filmId, @RequestBody Films films) throws NameInvalidException
	{
		try 
		{
			log.info("Calling update Film method for Film's ID : "+filmId);
			Films film = this.filmService.updateFilm(filmId,films);
			log.info("Showing all the details");
			return ResponseEntity.ok().body(film);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this ID : "+filmId);
			throw new NameInvalidException("Not Found for this ID : "+filmId);
		}
	}
	
	@DeleteMapping("films/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value="id") int filmId) throws NameInvalidException
	{
		log.info("Calling delete Film method for Film with this ID  : "+filmId);
		this.filmService.deleteFilm(filmId);
		log.info("Deletion of "+filmId+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
