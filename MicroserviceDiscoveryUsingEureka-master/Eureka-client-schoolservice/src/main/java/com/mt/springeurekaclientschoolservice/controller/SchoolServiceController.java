package com.mt.springeurekaclientschoolservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mt.springeurekaclientschoolservice.entities.School;
import com.mt.springeurekaclientschoolservice.exception.SchoolNotFoundException;
import com.mt.springeurekaclientschoolservice.repository.SchoolRepository;
import com.mt.springeurekaclientschoolservice.service.SchoolService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/school")
@RestController
public class SchoolServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	SchoolRepository schoolRepo;

	@GetMapping("/getSchoolDetails/{schoolName}")
	public ResponseEntity<School> getSchoolDetails(@PathVariable("schoolName") String schoolName) throws SchoolNotFoundException {
		log.info("In method getSchoolDetails");
		School school = schoolRepo.findByName(schoolName);
		if (school == null) {
			throw new SchoolNotFoundException("School with id " + schoolName + " not found");
		}
		schoolService.getSchoolDetails(schoolName);
		List students = this.restTemplate.getForObject("http://student-service/student/getStudent/" + school.getName(),
				List.class, schoolName);
		school.setStudents(students);
		return ResponseEntity.ok().body(school);
	}

	@PostMapping("/saveSchool")
	public ResponseEntity<String> saveSchool(@RequestBody School school) {
		log.info("In method saveSchool");
		schoolService.saveSchool(school);
		return new ResponseEntity<String>("School data saved successfully for name " + school.getName(),
				HttpStatus.CREATED);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
