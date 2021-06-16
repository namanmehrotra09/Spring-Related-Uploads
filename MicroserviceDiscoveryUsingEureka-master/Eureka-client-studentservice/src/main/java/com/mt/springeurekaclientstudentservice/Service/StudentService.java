package com.mt.springeurekaclientstudentservice.Service;

import java.util.List;

import com.mt.springeurekaclientstudentservice.entities.Student;

public interface StudentService 
{
	public Student getStudentByRollNumber(int rollNumber);

	public List<Student> getAllStudents();

	public void getStudentBySchoolName(String schoolName);

	public Student addStudent(Student students);

}
