package com.wipro.assetmanager.model;

import com.wipro.assetmanager.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.time.Instant;


@Entity
public class Employee {
	
	@Id
	@NotNull(message = "Employee Id is mandatory field")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Employee Id should be alpha numeric")
	private String id;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed")
	private String surname;
	
	@NotEmpty(message = "Employee Name is mandatory field")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed")
	private String name;
	
//	@Pattern(regexp = "^[0-9]*$", message = "Mobile No field accepts only Numeric Value")
	private Long number;
	
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed")
	private String location;
	
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed")
	private String designation;
	
	private Instant time;

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String surname, String name, Long number, String location, String designation) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.number = number;
		this.location = location;
		this.designation = designation;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", number=" + number + ", location="
				+ location + ", Designation=" + designation + "]";
	}
	
	

}
