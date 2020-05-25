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
    public List<Product> getAll() {
        List<ProductDto> productDtos = productRepository.findAll();

        List<Product> products = new ArrayList<>();

        for (ProductDto productDto:productDtos) {
            products.add(new Product(productDto.getId(), productDto.getName(), productDto.getDepartment().getId()));
        }

        return products;
    }

    @Override
    public List<Product> getAllByDepartmentId(Long id) {
        List<ProductDto> productDtos = productRepository.findAll();

        List<Product> products = new ArrayList<>();

        for (ProductDto productDto:productDtos) {
            if (productDto.getDepartment().getId() != id) continue;
            products.add(new Product(productDto.getId(), productDto.getName(), productDto.getDepartment().getId()));
        }

        return products;
    }
}
