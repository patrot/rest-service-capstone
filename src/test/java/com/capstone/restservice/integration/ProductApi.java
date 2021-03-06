package com.capstone.restservice.integration;

import com.capstone.restservice.domain.Product;
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
public class ProductApi {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String productsPath = "/products";

    @Test
    @DirtiesContext
    public void productsPathShouldReturnOkStatus() throws IOException {

        // Arrange

        HttpUriRequest request = new HttpGet("http://localhost:" + port + productsPath);

        // Act

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    @DirtiesContext
    public void productsPathShouldReturnAllProductsInPersistence() throws IOException {

        // Arrange

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(9L, "Long Sleeves", 1L));
        expectedProducts.add(new Product(10L, "Short Sleeves", 1L));
        expectedProducts.add(new Product(11L, "No Collar", 1L));
        expectedProducts.add(new Product(12L, "Straight", 2L));
        expectedProducts.add(new Product(13L, "Flared", 2L));
        expectedProducts.add(new Product(14L, "Cargo", 2L));

        HttpUriRequest request = new HttpGet("http://localhost:" + port + productsPath);

        // Act

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert

        String response = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> actualProducts = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedProducts.toArray(), actualProducts.toArray()));
    }
}
