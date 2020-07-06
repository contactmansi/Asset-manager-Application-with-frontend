package com.wipro.assetmanager.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {

	@NotBlank(message = "Employee Id is mandatory field")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Employee Id should be alpha numeric")
	@Size(max=30, message="Only 30 characters allowed")
	private String id;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed")
	@Size(max=30, message="Only 30 characters allowed")
	private String surname;
	
	@NotBlank(message = "Employee Name is mandatory field")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed")
	@Size(max=30, message="Only 30 characters allowed")
	private String name;

	private Long number;

	@Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed")
	@Size(max=30, message="Only 30 characters allowed")
	private String location;

	@NotBlank(message = "Designation is mandatory field")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed")
	@Size(max=30, message="Only 30 characters allowed")
	private String designation;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmployeeDto(
			@NotBlank(message = "Employee Id is mandatory field") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Employee Id should be alpha numeric") @Size(max = 30, message = "Only 30 characters allowed") String id,
			@Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed") @Size(max = 30, message = "Only 30 characters allowed") String surname,
			@NotBlank(message = "Employee Name is mandatory field") @Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabets allowed") @Size(max = 30, message = "Only 30 characters allowed") String name,
			Long number,
			@Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed") @Size(max = 30, message = "Only 30 characters allowed") String location,
			@NotBlank(message = "Designation is mandatory field") @Pattern(regexp = "^[A-Za-z ]*$", message = "Only alphabets allowed") @Size(max = 30, message = "Only 30 characters allowed") String designation) {
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
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", number=" + number + ", Location="
				+ location + ", Designation=" + designation + "]";
	}
	
	

}
