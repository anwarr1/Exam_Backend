package org.example.exam_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {
    @ManyToMany
    List<Employee> employees;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double budget;
}
