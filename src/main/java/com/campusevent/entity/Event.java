package com.campusevent.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
