package com.registration.ekart_backend.service;

import com.registration.ekart_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long empId);

    List<EmployeeDto> getAllEMployee();
}
