package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.respository.DepartmentDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class DepartmentServiceTest {


    @Test
    public void GetAllDepartmentsTest() {

        // Arrange
        List<Department> expectedDepartments = new ArrayList<>();

        MockDepartmentRepository mockDepartmentRepository = new MockDepartmentRepository();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.setRepository(mockDepartmentRepository);

        for (DepartmentDto departmentDto:mockDepartmentRepository.findAll()) {
            expectedDepartments.add(new Department(departmentDto.getId(), departmentDto.getName()));
        }

        // Act
        List<Department> actualDepartments = departmentService.GetAll();

        // Assert
        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
