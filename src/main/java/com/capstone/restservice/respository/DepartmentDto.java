package com.capstone.restservice.respository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DepartmentDto {
    private @Id @GeneratedValue Long id;
    private String name;

    public DepartmentDto() {}

    public DepartmentDto(String name) {
        this.name = name;
    }
}
