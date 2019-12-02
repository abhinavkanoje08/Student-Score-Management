package com.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student_details")
public class Student {

@Id
@Column(name = "enrollmentid")
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer enrollmentId;

@NotNull
@Column(name = "firstname")
@Size(max = 100)
@Pattern(regexp="^[A-Za-z]*$")
private String firstName;

@NotNull
@Column(name = "lastname")
@Size(max = 100)
@Pattern(regexp="^[A-Za-z]*$")
private String lastName;

@NotNull
@Column(name = "score")
@Min(value = 0, message ="score can't be less than 0 or more than 100")
@Max(value = 100)
private int score;

@NotNull
@Column(name = "grade")
private String grade;

@NotNull
@Pattern(regexp="^(?:m|M|male|Male|f|F|female|Female|MALE|FEMALE)$")
@Column(name = "gender")
private String gender;



public Student() {
	super();
}



public Student(Integer enrollmentId, @NotNull @Size(max = 100) @Pattern(regexp = "^[A-Za-z]*$") String firstName,
		@NotNull @Size(max = 100) @Pattern(regexp = "^[A-Za-z]*$") String lastName,
		@NotNull @Min(value = 0, message = "score can't be less than 0 or more than 100") @Max(100) int score,
		@NotNull String grade,
		@NotNull @Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female|MALE|FEMALE)$") String gender) {
	super();
	this.enrollmentId = enrollmentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.score = score;
	this.grade = grade;
	this.gender = gender;
}



public Integer getEnrollmentId() {
	return enrollmentId;
}

public void setEnrollmentId(Integer enrollmentId) {
	this.enrollmentId = enrollmentId;
}



public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public String getLastName() {
	return lastName;
}



public void setLastName(String lastName) {
	this.lastName = lastName;
}



public int getScore() {
	return score;
}



public void setScore(int score) {
	this.score = score;
}



public String getGrade() {
	return grade;
}



public void setGrade(String grade) {
	this.grade = grade;
}



public String getGender() {
	return gender;
}



public void setGender(String gender) {
	this.gender = gender;
}



}
