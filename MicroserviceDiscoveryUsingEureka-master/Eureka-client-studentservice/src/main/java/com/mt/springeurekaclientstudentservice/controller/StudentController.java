package com.mt.springeurekaclientstudentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springeurekaclientstudentservice.Service.StudentService;
import com.mt.springeurekaclientstudentservice.entities.Student;
import com.mt.springeurekaclientstudentservice.exception.StudentNotFoundException;
import com.mt.springeurekaclientstudentservice.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController 
{
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		log.info("In method getAllStudents");
		List<Student> studentList = studentService.getAllStudents();
		if (studentList.isEmpty()) {
			throw new StudentNotFoundException("No students data found");
		}
		return ResponseEntity.ok().body(studentList);
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student students) 
	{
		log.info("In method saveStudent");
		Student student = studentService.addStudent(students);
		return new ResponseEntity<String>("Student data saved successfully for name " + student,
				HttpStatus.CREATED);
	}

	@GetMapping("/getStudentByRollNumber/{id}")
	public ResponseEntity<String> getStudentByRollNumber(@PathVariable(value = "id") int rollNumber) 
	{
		try 
		{
			log.info("Showing all the details of Student by their roll number : "+rollNumber);
			Student student = studentService.getStudentByRollNumber(rollNumber);
			log.info("Showing all the details for Student : "+rollNumber);
			return ResponseEntity.ok().body("Displaying Details : "+student);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this roll number : "+rollNumber);
			throw new StudentNotFoundException("Not found with roll number : "+rollNumber);
		}
	}

	@GetMapping("/getStudent/{schoolName}")
	public ResponseEntity<List<Student>> getStudentBySchoolId(@PathVariable("schoolName") String schoolName) {
		log.info("In method getStudent");
		List<Student> students = studentRepository.getStudentBySchoolName(schoolName);
		if (students.isEmpty()) {
			throw new StudentNotFoundException("Student with School name = " + schoolName + " not found");
		}
		studentService.getStudentBySchoolName(schoolName);
		return ResponseEntity.ok().body(students);
	}
}
