package com.springrest.repository;

import com.springrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public Employee findById(long id);
    public List<Employee> findAllByOrderByIdDesc();

}
