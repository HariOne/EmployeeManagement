package com.registration.ekart_backend.mapper;

import com.registration.ekart_backend.dto.EmployeeDto;
import com.registration.ekart_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapEmployeeToEmployeeDto(Employee emp){
        return new EmployeeDto(
              emp.getId(),
              emp.getFirstName(),
              emp.getLastName(),
              emp.getEmail()
        );
    }

    public static Employee mapEmployeeDtotoEmployee(EmployeeDto empdto){
        return new Employee(
           empdto.getId(),empdto.getFirstName(),empdto.getLastName(),empdto.getEmail()
        );
    }
}
