package com.campusevent.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    // Inside com.campusevent.entity.Student
// ... other fields and annotations

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
