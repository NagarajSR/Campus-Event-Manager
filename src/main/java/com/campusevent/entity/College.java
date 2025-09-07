package com.campusevent.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // This field is managed by the student side of the relationship.
    // We mark it as @Transient to ensure it's ignored during JSON deserialization
    // for College creation, as the front-end will not provide it.
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    @Transient
    private List<Student> students;

    // A no-argument constructor is required by JPA and Spring
    public College() {
    }

    // Constructor to easily create a new College instance with a name
    public College(String name) {
        this.name = name;
    }

    // Getters and Setters are required for JSON deserialization
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}