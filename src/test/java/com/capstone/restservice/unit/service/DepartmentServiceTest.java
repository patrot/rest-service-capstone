package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.service.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DepartmentServiceTest {


    @Test
    public void GetAllDepartmentsTest() {

        // Arrange

        List<DepartmentDto> departmentDtos = new ArrayList<>();
        departmentDtos.add(new DepartmentDto("Shirt"));
        departmentDtos.add(new DepartmentDto("Trousers"));

        MockDepartmentRepository mockDepartmentRepository = new MockDepartmentRepository(departmentDtos);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.setRepository(mockDepartmentRepository);

        List<Department> expectedDepartments = new ArrayList<>();
        for (DepartmentDto departmentDto:departmentDtos) {
            expectedDepartments.add(new Department(departmentDto.getId(), departmentDto.getName()));
        }

        // Act
        List<Department> actualDepartments = departmentService.GetAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));

        assertEquals(1, mockDepartmentRepository.getFindAllInvocationCount());
    }
}
