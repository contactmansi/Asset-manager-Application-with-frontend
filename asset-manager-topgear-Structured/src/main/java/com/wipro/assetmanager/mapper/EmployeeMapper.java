package com.wipro.assetmanager.mapper;

import com.wipro.assetmanager.dto.EmployeeDto;
import com.wipro.assetmanager.model.Employee;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapDto(EmployeeDto employee) {
        Employee model = new Employee();
        Optional.ofNullable(employee.getId()).ifPresent(id -> model.setId(id));
        Optional.ofNullable(employee.getDesignation()).ifPresent(designation -> model.setDesignation(designation));
        Optional.ofNullable(employee.getLocation()).ifPresent(location -> model.setLocation(location));
        Optional.ofNullable(employee.getName()).ifPresent(name -> model.setName(name));
        Optional.ofNullable(employee.getNumber()).ifPresent(number -> model.setNumber(number));
        Optional.ofNullable(employee.getSurname()).ifPresent(surname -> model.setSurname(surname));
        model.setTime(Instant.now());

        return model;
    }
}
