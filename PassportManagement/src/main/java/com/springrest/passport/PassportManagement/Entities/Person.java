package com.springrest.passport.PassportManagement.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person 
{
	@Id
	private long id;
	private String name;
	private byte age;
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Passport_ID")
	private Passport passport;
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(long id, String name, byte age, String gender,Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.passport= passport;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", passport=" + passport
				+ "]";
	}
	
	
}
