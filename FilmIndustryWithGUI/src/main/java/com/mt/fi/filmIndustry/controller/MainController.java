package com.mt.fi.filmIndustry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController 
{
	 @RequestMapping(value = "/index")
	 public String index() 
	 {
		 return "index";
	 }
	 
	 @RequestMapping(value = "/film")
	 public String film()
	 {
		 return "film";
	 }
	 
	 //The Controller for Films
	 
	 @RequestMapping(value = "/all-films")
	 public String allFilms()
	 {
		 return "all-films";
	 }
	 
	 @RequestMapping(value = "/add-film")
	 public String addFilms()
	 {
		 return "add-film";
	 }
	 
	 @RequestMapping(value = "/delete-film")
	 public String deleteFilm()
	 {
		 return "delete-film";
	 }

	 @RequestMapping(value = "/update-film")
	 public String updateFilm()
	 {
		 return "update-film";
	 }
	 
	 @RequestMapping(value = "/single-film")
	 public String singleFilm()
	 {
		 return "single-film";
	 }
	 
	 @RequestMapping("/director")
	 public String director()
	 {
		 return "director";
	 }
	 
	//The Controller for Directors
	 
	 @RequestMapping(value = "/all-directors")
	 public String allDirectors() 
	 {
	     return "all-directors";
	 }

	 @RequestMapping(value = "/add-director")
	 public String adddirector() 
	 {
		 return "add-director";
	 }
	 
	 @RequestMapping(value = "/update-director")
	 public String updatedirector() 
	 {
		 return "update-director";
	 }
	 
	 @RequestMapping(value = "/delete-director")
	 public String deleteDirector() 
	 {
		 return "delete-director";
	 }
	 
	 @RequestMapping(value = "/director-name")
	 public String workOfDirector() 
	 {
		 return "director-name";
	 }
	 
}
