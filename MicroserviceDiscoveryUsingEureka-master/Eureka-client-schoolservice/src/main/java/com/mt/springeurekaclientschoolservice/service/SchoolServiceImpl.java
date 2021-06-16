package com.mt.springeurekaclientschoolservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.springeurekaclientschoolservice.entities.School;
import com.mt.springeurekaclientschoolservice.repository.SchoolRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	@Override
	public void saveSchool(School school) {
		log.info("In method saveSchool");
		schoolRepository.save(school);
	}

	@Override
	public void getSchoolDetails(String schoolName) {
		log.info(("In method getSchoolDetails"));
		schoolRepository.findByName(schoolName);
	}

}
