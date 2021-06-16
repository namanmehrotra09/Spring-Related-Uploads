package com.mt.springeurekaclientstudentservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mt.springeurekaclientstudentservice.entities.Student;
import com.mt.springeurekaclientstudentservice.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Student addStudent(Student student) 
	{
		log.info("In method saveStudent");
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() 
	{
		log.info("In method getAllStudents");
		return studentRepo.findAll();
	}

	@Override
	public void getStudentBySchoolName(String schoolName) 
	{
		log.info("In method getStudentBySchoolName");
		studentRepo.getStudentBySchoolName(schoolName);
	}

	@Override
	public Student getStudentByRollNumber(int rollNumber) {
		log.info("In method getStudentByRollNumber");
		return studentRepo.getOne(rollNumber);
	}

}