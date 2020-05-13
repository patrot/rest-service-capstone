package com.capstone.restservice.service;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.respository.ProductDto;
import com.capstone.restservice.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> GetAll() {
        List<ProductDto> productDtos = productRepository.findAll();

        List<Product> products = new ArrayList<>();

        for (ProductDto productDto:productDtos) {
            products.add(new Product(productDto.getId(), productDto.getName(), productDto.getDepartment().getId()));
        }

        return products;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
