package com.springrest.controller;

import com.springrest.dto.CourseDTO;
import com.springrest.entity.Employee;
import com.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employeeDetails) {
        employeeService.create(employeeDetails);
        return new ResponseEntity<Object>("Course Created successfully", HttpStatus.CREATED);
    }

    // Update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") int id,
                                                       @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployeeById(id, employeeDetails);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "id") int id) throws Exception {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}
