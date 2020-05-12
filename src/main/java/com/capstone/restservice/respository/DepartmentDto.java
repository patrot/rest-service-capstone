package com.capstone.restservice.respository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class DepartmentDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    public DepartmentDto() {}

    public DepartmentDto(String name) {
        this.name = name;
    }
}
