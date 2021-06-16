package com.springrest.passport.PassportManagement.Controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.passport.PassportManagement.Entities.Passport;
import com.springrest.passport.PassportManagement.Entities.Person;
import com.springrest.passport.PassportManagement.Repository.PersonRepository;
import com.springrest.passport.PassportManagement.Service.PassportService;


@RestController
public class MyController 
{
	@Autowired
	private PassportService passService;
	@Autowired
	private PersonRepository pRepo;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home page";
	}
	
	// Get All Persons
	@GetMapping("/persons")
	public List<Person> getPersons()
	{
		return this.passService.getPersons();
	}
	
	// Get One person by ID
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable(value="id") Long personID) throws AttributeNotFoundException
	{
		Person person = pRepo.findById(personID).orElseThrow(()-> new AttributeNotFoundException("Person Not Found : " +personID));
		return ResponseEntity.ok().body(person);
	}
	
	//Add Person
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person)
	{
		return this.passService.addPerson(person);
	}
	
	
//	@PostMapping("/passports")
//	public Passport addPassport(@PathVariable(value="id") Passport pass)
//	{
//		return this.passService.addPassport(pass);
//	}
	//AddPassport
	@PostMapping("/passports")
	public Passport addPassport(@RequestBody Passport passport)
	{
		return this.passService.addPassport(passport);
	}
	//Update Person
	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person)
	{
		return this.passService.updatePerson(person);
	}
}
