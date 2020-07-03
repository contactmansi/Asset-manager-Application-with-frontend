package com.wipro.assetmanager.dto;


public class EmployeeDto {

	private String id;
	
	private String surname;

	private String name;

	private Long number;

	private String location;

	private String designation;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(String id, String surname, String name, Long number, String location, String designation) {
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
