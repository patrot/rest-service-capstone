package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
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
        expectedDepartments.add(new Department(100, "Shirt"));
        expectedDepartments.add(new Department(200, "Trousers"));

        DepartmentService departmentService = new DepartmentServiceImpl();

        // Act
        List<Department> actualDepartments = departmentService.GetAll();

        // Assert
        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
