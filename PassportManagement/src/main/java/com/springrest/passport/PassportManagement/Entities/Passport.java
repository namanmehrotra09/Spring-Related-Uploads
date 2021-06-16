package com.springrest.passport.PassportManagement.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String issuePlace;
	private String issueDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIssuePlace() {
		return issuePlace;
	}
	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(long id, String issuePlace, String issueDate) {
		super();
		this.id = id;
		this.issuePlace = issuePlace;
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", issuePlace=" + issuePlace + ", issueDate=" + issueDate + "]";
	}
	
}
