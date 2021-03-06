package com.capstone.restservice.integration;

import com.capstone.restservice.domain.Department;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DepartmentApi {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String departmentsPath = "/departments";

    @Test
    @DirtiesContext
    public void departmentsPathShouldReturnOkStatus() throws IOException {

        // Arrange
        HttpUriRequest request = new HttpGet("http://localhost:" + port + departmentsPath);

        // Act
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    @DirtiesContext
    public void departmentsPathShouldReturnAllDepartmentsInPersistence() throws IOException {

        // Arrange

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(1L,"Shirts"));
        expectedDepartments.add(new Department(2L,"Trousers"));
        expectedDepartments.add(new Department(3L,"Jackets"));
        expectedDepartments.add(new Department(4L,"Jeans"));
        expectedDepartments.add(new Department(5L,"Caps"));
        expectedDepartments.add(new Department(6L,"Pajamas"));
        expectedDepartments.add(new Department(7L,"Skirts"));
        expectedDepartments.add(new Department(8L,"Sweaters"));

        HttpUriRequest request = new HttpGet("http://localhost:" + port + departmentsPath);

        // Act

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert

        String response = EntityUtils.toString(httpResponse.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Department> actualDepartments = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
