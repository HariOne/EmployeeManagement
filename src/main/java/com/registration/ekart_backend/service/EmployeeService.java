package com.registration.ekart_backend.service;

import com.registration.ekart_backend.dto.EmployeeDto;
import com.registration.ekart_backend.mapper.EmployeeMapper;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long empId);

    List<EmployeeDto> getAllEMployee();

    EmployeeDto updateEmployee(Long empId,EmployeeDto employeeDto);

    public void deleteEmployee(Long empId);

    EmployeeDto genericLogin(EmployeeDto employeeDto);
}
