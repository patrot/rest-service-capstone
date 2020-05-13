package com.capstone.restservice.respository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentDto department;

    public ProductDto() {}

    public ProductDto(String name, DepartmentDto department) {
        this.name = name;
        this.department = department;
    }
}
