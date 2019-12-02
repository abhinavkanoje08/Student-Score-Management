package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.student.model.Student;
import com.student.repository.StudentRepository;




@Service
public class StudentService implements IStudentService
{
	@Autowired
	private StudentRepository studentRepository; 

	public List<Student> getStudentsList() {
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student newStudent) {
		addStudentGrade(newStudent);
		return studentRepository.save(newStudent);
	}

	/* public ResponseEntity<Object> updateStudent(Student newStudent,Integer id) {
		addStudentGrade(newStudent);
		Optional<Student> student = studentRepository.findById(id);
		
		if (!student.isPresent())
			return ResponseEntity.notFound().build();
		newStudent.setEnrollmentId(id);
		studentRepository.save(newStudent);
		return ResponseEntity.noContent().build();
	} */
	
	public ResponseEntity<Object> updateStudent(Student newStudent,Integer id) {
		addStudentGrade(newStudent);
		Optional<Student> student = studentRepository.findById(id);
		
		if (!student.isPresent())
			return ResponseEntity.notFound().build();
		newStudent.setEnrollmentId(id);
		studentRepository.save(newStudent);
		return ResponseEntity.noContent().build();
	} 

	@Override
	public void deleteStudentById(int id) {
		  studentRepository.deleteById(id);	  
	}
	
	public void addStudentGrade(Student newStudent)
	{
		if(newStudent.getScore() >=81 && newStudent.getScore() <= 100)
		{
			newStudent.setGrade("A");			
		}
		else if(newStudent.getScore() >=61 && newStudent.getScore() <= 80) {
			newStudent.setGrade("B");			
		}
		else if(newStudent.getScore() >=41 && newStudent.getScore() <= 60) {
			newStudent.setGrade("C");			
		}
		else
		{
			newStudent.setGrade("F");
			
		}
	}
	
	
}
