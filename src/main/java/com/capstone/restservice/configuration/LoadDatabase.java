package com.capstone.restservice.configuration;

import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DepartmentRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new DepartmentDto("Shirts")));
            log.info("Preloading " + repository.save(new DepartmentDto("Trousers")));
        };
    }
}
