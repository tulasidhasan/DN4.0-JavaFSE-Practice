package com.example.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.ems.model.Employee;

@Repository
public class EmployeeDao {
    @Autowired
    @Qualifier("employeeList")
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
