package com.student.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.model.Student;

public interface IStudentService {

	List<Student> getStudentsList();
	
	Student addStudent(Student newStudent);
	
	ResponseEntity<Object> updateStudent( Student student,Integer id);
	
	void deleteStudentById(int id);
	
	void addStudentGrade(Student newStudent);
}
