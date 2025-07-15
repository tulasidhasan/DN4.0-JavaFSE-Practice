package com.example.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ems.dao.EmployeeDao;
import com.example.ems.model.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
