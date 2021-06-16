package com.mt.springeurekaclientschoolservice.service;

import com.mt.springeurekaclientschoolservice.entities.School;

public interface SchoolService {

	public void saveSchool(School school);

	public void getSchoolDetails(String schoolName);

}
