package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> GetAll() {
        return repository.findAll();
    }

    public void setRepository(DepartmentRepository repository) {
        this.repository = repository;
    }
}
