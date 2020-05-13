package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.ProductDto;
import com.capstone.restservice.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTests {

    @Test
    public void GetAllProductsTest() {

        // Arrange

        DepartmentDto departmentDto = new DepartmentDto("Shirts");

        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto( "Long Sleeves", departmentDto));
        productDtos.add(new ProductDto("Short Sleeves", departmentDto));

        MockProductRepository mockProductRepository = new MockProductRepository(productDtos);
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductRepository(mockProductRepository);

        List<Product> expectedProducts = new ArrayList<>();
        for (ProductDto productDto:productDtos) {
            expectedProducts.add(new Product(productDto.getId(), productDto.getName(), departmentDto.getId()));
        }

        // Act

        List<Product> actualProducts = productService.GetAll();

        // Assert

        assertEquals(1, mockProductRepository.getFindAllInvocationCount());

        assertTrue(Arrays.deepEquals(expectedProducts.toArray(), actualProducts.toArray()));
    }
}
