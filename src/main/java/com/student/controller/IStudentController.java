package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.model.Student;

public interface IStudentController {
	
	List<Student> getStudentsList();
	
	Student addStudent(Student newStudent);
	
	String updateStudent( Student student,Integer id);
	
	String deleteStudentById( int id);

}
