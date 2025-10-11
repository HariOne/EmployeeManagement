package com.registration.ekart_backend.service;

import com.registration.ekart_backend.dto.EmployeeDto;
import com.registration.ekart_backend.entity.Employee;
import com.registration.ekart_backend.exception.ResourceNotFoundException;
import com.registration.ekart_backend.mapper.EmployeeMapper;
import com.registration.ekart_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapEmployeeDtotoEmployee(employeeDto);
        Employee resEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeToEmployeeDto(resEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
       Employee employee=  employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee Not exists with the provided id:"+empId));
        return EmployeeMapper.mapEmployeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEMployee() {
        List<Employee> listEmp = employeeRepository.findAll();
        List<EmployeeDto> listEmpDTO = listEmp.stream().map((listmap1) ->EmployeeMapper.mapEmployeeToEmployeeDto(listmap1)).collect(Collectors.toList());
        return listEmpDTO;
    }
}
