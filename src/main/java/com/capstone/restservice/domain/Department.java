package com.capstone.restservice.domain;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String name;

    public Department() {
        super();
    }

    public Department(Long id, String name) {
        this.name = name;
    }

}
