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

    @Override
    public EmployeeDto updateEmployee(Long empId,EmployeeDto employeeDto) {

        Employee employee=  employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee Not exists with the provided id:"+empId));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

       Employee saveEmp =  employeeRepository.save(employee);
       return EmployeeMapper.mapEmployeeToEmployeeDto(saveEmp);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee=  employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee Not exists with the provided id:"+empId));
         employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto genericLogin(EmployeeDto employeeDto) {
        List<Employee> listEmp = employeeRepository.findAll();
        Employee employee = EmployeeMapper.mapEmployeeDtotoEmployee(employeeDto);

        Employee matchedEmployee = listEmp.stream()
                .filter(emp -> emp.getFirstName().equalsIgnoreCase(employeeDto.getFirstName()))
                .findFirst()
                .orElse(null);
        return EmployeeMapper.mapEmployeeToEmployeeDto(matchedEmployee);
    }
}
