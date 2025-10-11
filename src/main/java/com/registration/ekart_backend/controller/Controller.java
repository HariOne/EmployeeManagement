package com.registration.ekart_backend.controller;

import com.registration.ekart_backend.dto.EmployeeDto;
import com.registration.ekart_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1")
@AllArgsConstructor
public class Controller {

    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto resutEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(resutEmployee,HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeByID(@PathVariable("id") Long empId){
      return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @GetMapping("All")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> allEmp = employeeService.getAllEMployee();
        return ResponseEntity.ok(allEmp);
    }

     @PostMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empID,
                                                      @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(empID,employeeDto);
        return  ResponseEntity.ok(employeeDto1);
    }
}
