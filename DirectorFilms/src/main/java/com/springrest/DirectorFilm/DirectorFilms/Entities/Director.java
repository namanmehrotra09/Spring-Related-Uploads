package com.springrest.DirectorFilm.DirectorFilms.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director 
{
	@Id
	private String directorName;
	private byte age;
	private String gender;
	private int awardCount;
	
	
	@ManyToMany(mappedBy = "directedBy")
	private List<Films> films;

	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Director(String directorName, byte age, String gender, int awardCount) {
		super();
		this.directorName = directorName;
		this.age = age;
		this.gender = gender;
		this.awardCount = awardCount;
	}


	public String getDirectorName() {
		return directorName;
	}


	public void setDirectorName(String directorName) {
		this.directorName = directorName;
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


	public int getAwardCount() {
		return awardCount;
	}


	public void setAwardCount(int awardCount) {
		this.awardCount = awardCount;
	}


	@Override
	public String toString() {
		return "Director [directorName=" + directorName + ", age=" + age + ", gender=" + gender + ", awardCount="
				+ awardCount + ""+"]";
	}
	
}
