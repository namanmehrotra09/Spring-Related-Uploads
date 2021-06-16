package com.springrest.passport.PassportManagement.Service;

import java.util.List;

import com.springrest.passport.PassportManagement.Entities.Passport;
import com.springrest.passport.PassportManagement.Entities.Person;

public interface PassportService 
{
	public List<Person> getPersons();
	
	public Person getPerson(long personID);
	
	public Person addPerson(Person person);
	
	public Passport addPassport(Passport passport);
	
	public Person updatePerson(Person person);
}
