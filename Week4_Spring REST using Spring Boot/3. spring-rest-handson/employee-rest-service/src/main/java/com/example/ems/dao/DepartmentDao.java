package com.example.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.ems.model.Department;

@Repository
public class DepartmentDao {
    @Autowired
    @Qualifier("departmentList")
    private List<Department> departmentList;

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
