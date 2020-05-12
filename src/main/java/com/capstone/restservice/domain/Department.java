package com.capstone.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    private @Id int id;
    private String name;

    public Department() {
        super();
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Department)) {
            return false;
        }
        Department department = (Department) obj;
        return id == department.id && name.equals(department.name);
    }
}
