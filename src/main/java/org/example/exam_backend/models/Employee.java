package org.example.exam_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee {
    String name;
    String email;
    @ManyToMany
    List<Skill> skills;
    @ManyToMany
    List<Project> projects;
    @Enumerated(EnumType.STRING)
    Post post;
    @Id
    @GeneratedValue
    private Long id;
}
