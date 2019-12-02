package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/entry")
public class StudentController implements IStudentController{

	@Autowired
	private StudentService studentService; 
	
	@GetMapping(value="/showAll")
	public List<Student> getStudentsList() {
		return  studentService.getStudentsList();
		
	}

	@PostMapping(value="/addStudent",headers="Accept=application/json")
	public Student addStudent(@Valid @RequestBody Student newStudent) {
		System.out.println("Hello Inside Post");
		//addStudentGrade(newStudent);
		return studentService.addStudent(newStudent);
		
		
	}

	@PutMapping(value="/updateStudent/{id}",headers="Accept=application/json")
	public String updateStudent(@Valid @RequestBody Student newStudent ,@PathVariable(value = "id") Integer id) {
		//addStudentGrade(newStudent);
		//return studentService.updateStudent(newStudent,id);
		studentService.updateStudent(newStudent,id);
		return "Student has been updated successfully of id"+" "+id;
	}
	
	@DeleteMapping(value="/deleteStudent/{id}",headers="Accept=application/json")
	public String deleteStudentById(@Valid @PathVariable int id) {
		studentService.deleteStudentById(id);
		return "Student has been deleted with id"+" "+id;
	}
	
//	public void addStudentGrade(Student newStudent)
//	{
//		if(newStudent.getScore() >=81 && newStudent.getScore() <= 100)
//		{
//			newStudent.setGrade("A");			
//		}
//		else if(newStudent.getScore() >=61 && newStudent.getScore() <= 80) {
//			newStudent.setGrade("B");			
//		}
//		else if(newStudent.getScore() >=41 && newStudent.getScore() <= 60) {
//			newStudent.setGrade("C");			
//		}
//		else
//		{
//			newStudent.setGrade("F");
//			
//		}
//	}
	
	
}