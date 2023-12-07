package com.springrest.service;

import com.springrest.entity.Employee;
import com.springrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    // Create employee
    public void create(Employee employeeDetails) {
        employeeRepository.save(employeeDetails);
    }
    // Update employee by ID
    public Employee updateEmployeeById(int id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id);

        employee.setName(employeeDetails.getName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setSalary(employeeDetails.getSalary());

        return employeeRepository.save(employee);
    }

    // Delete employee by ID
    public void deleteEmployeeById(int id) throws Exception {
        if (!employeeRepository.existsById(id)) {
            throw new Exception("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}