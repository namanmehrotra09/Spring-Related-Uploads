package com.springrest.passport.PassportManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.passport.PassportManagement.Entities.Passport;
import com.springrest.passport.PassportManagement.Entities.Person;
import com.springrest.passport.PassportManagement.Repository.PassportRepository;
import com.springrest.passport.PassportManagement.Repository.PersonRepository;

@Service
public class PassportServiceImpl implements PassportService 
{
	@Autowired
	private PersonRepository passRepo;
	private PassportRepository pRepo;

	@Override
	public List<Person> getPersons() 
	{	
		return passRepo.findAll();
	}

	@Override
	public Person getPerson(long personID) 
	{
		return passRepo.getOne(personID);
	}

	@Override
	public Person addPerson(Person person) 
	{
		return passRepo.save(person);
	}

	@Override
	public Person updatePerson(Person person) 
	{
		return passRepo.save(person);
	}

	@Override
	public Passport addPassport(Passport passport) 
	{
		return pRepo.save(passport);
	}

}
