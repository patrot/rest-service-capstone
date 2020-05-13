package com.capstone.restservice.configuration;

import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.DepartmentRepository;
import com.capstone.restservice.respository.ProductDto;
import com.capstone.restservice.respository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DepartmentRepository departmentRepository, ProductRepository productRepository) {
        return args -> {
            log.info("IN Main Configuration!!");
            log.info("Existing department items count " + departmentRepository.count());
            if (departmentRepository.count() < 1) {
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Shirts")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Trousers")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Jackets")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Jeans")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Caps")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Pajamas")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Skirts")));
                log.info("Preloading " + departmentRepository.save(new DepartmentDto("Sweaters")));
            }

            log.info("Existing product items count " + productRepository.count());
            if (productRepository.count() < 1) {
                log.info("Now create product repository items");
                List<DepartmentDto> departmentDtos = departmentRepository.findAll();
                for (DepartmentDto departmentDto:departmentDtos) {
                    if (departmentDto.getName().equals("Shirts")) {
                        log.info("Preloading " + productRepository.save(new ProductDto("Long Sleeves", departmentDto)));
                        log.info("Preloading " + productRepository.save(new ProductDto("Short Sleeves", departmentDto)));
                        log.info("Preloading " + productRepository.save(new ProductDto("No Collar", departmentDto)));
                    }
                    if (departmentDto.getName().equals("Trousers")) {
                        log.info("Preloading " + productRepository.save(new ProductDto("Straight", departmentDto)));
                        log.info("Preloading " + productRepository.save(new ProductDto("Flared", departmentDto)));
                        log.info("Preloading " + productRepository.save(new ProductDto("Cargo", departmentDto)));
                    }
                }
            }
        };
    }
}
