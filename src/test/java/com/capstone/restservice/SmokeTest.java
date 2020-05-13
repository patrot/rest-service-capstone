package com.capstone.restservice;

import com.capstone.restservice.controller.DepartmentController;
import com.capstone.restservice.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private DepartmentController departmentController;

    @Autowired
    private ProductController productController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(departmentController).isNotNull();
        assertThat(productController).isNotNull();
    }
}
