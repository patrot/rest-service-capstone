package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> GetAll() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(100, "Shirt"));
        departments.add(new Department(200, "Trousers"));
        return departments;
    }
}
