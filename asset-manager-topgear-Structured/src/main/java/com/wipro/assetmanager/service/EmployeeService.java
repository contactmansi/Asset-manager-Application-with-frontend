package com.wipro.assetmanager.service;

import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.exceptions.GenericException;
import com.wipro.assetmanager.mapper.EmployeeMapper;
import com.wipro.assetmanager.model.Employee;
import com.wipro.assetmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmployeeService {

	@Autowired
	public EmployeeMapper employeeMapper;

	@Autowired
	public EmployeeRepository employeeRepository;

	public void addEmployee(EmployeeDto employee){
		//Check employee object is not null

		//ID: If empty, display error message: Employee Id is mandatory field
		//If not alpha numeric: Employee Id should be alpha numeric

		//sURNAME : If invalid, the error message should be: Only alphabets allowed

		//NAME : If empty, display error message: Employee Name is mandatory field
		
		//If Invalid: Only alphabets allowed

		//NUMBER : If invalid, display error message: Mobile No field accepts only Numeric Value

		//LOCATION : If invalid, the error message should be: Only alphabets allowed

		//DESIGNATION : If invalid, the error message should be: Only alphabets allowed

		//SAVE: On successful, take the user to home page.
		//On failure, Display message “Error occurred while saving” in the same page.
		try {
			//map employeeDto to Employee class
			Employee model = employeeMapper.mapDto(employee);
			employeeRepository.save(model);
			//Redirection to home page
		}
		catch(Exception e) {
			//Print and stay on the same page
			System.out.println("------ Printing stack trace while saving employee ------");
			e.printStackTrace();
			throw new GenericException("Error occurred while saving");
		}

	}

}
