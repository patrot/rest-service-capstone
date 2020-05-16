package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.ProductDto;
import com.capstone.restservice.respository.ProductRepository;
import com.capstone.restservice.service.ProductService;
import com.capstone.restservice.service.ProductServiceImpl;
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

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @Autowired
    ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        DepartmentDto departmentDto = new DepartmentDto("Shirts");
        departmentDto.setId(1L);

        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto( "Long Sleeves", departmentDto));
        productDtos.add(new ProductDto("Short Sleeves", departmentDto));

        productDtos.get(0).setId(100L);
        productDtos.get(1).setId(200L);

        Mockito.when(productRepository.findAll())
                .thenReturn(productDtos);
    }

    @Test
    public void getAllProductsTest() {

        // Arrange

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(100L, "Long Sleeves", 1L));
        expectedProducts.add(new Product(200L, "Short Sleeves", 1L));

        // Act

        List<Product> actualProducts = productService.GetAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedProducts.toArray(), actualProducts.toArray()));
    }
}
