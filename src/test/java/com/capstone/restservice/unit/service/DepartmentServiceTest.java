package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.DepartmentRepository;
import com.capstone.restservice.service.DepartmentService;
import com.capstone.restservice.service.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DepartmentServiceTest {

    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public DepartmentService departmentService() {
            return new DepartmentServiceImpl();
        }
    }

    @Autowired
    DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Before
    public void setUp() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        departmentDtos.add(new DepartmentDto("Shirt"));
        departmentDtos.add(new DepartmentDto("Trousers"));

        departmentDtos.get(0).setId(100L);
        departmentDtos.get(1).setId(200L);

        Mockito.when(departmentRepository.findAll())
                .thenReturn(departmentDtos);
    }

    @Test
    public void getAllDepartmentsTest() {

        //Arrange

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(100L,"Shirt"));
        expectedDepartments.add(new Department(200L,"Trousers"));

        // Act

        List<Department> actualDepartments = departmentService.getAll();

        // Assert

        verify(departmentRepository, times(1)).findAll();

        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
