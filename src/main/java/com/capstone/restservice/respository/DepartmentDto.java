package com.capstone.restservice.respository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class DepartmentDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    //@OneToMany(mappedBy = "product")
    //private List<ProductDto> productDtos;

    public DepartmentDto() {}

    public DepartmentDto(String name) {
        this.name = name;
    }
}
