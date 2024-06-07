package org.example.exam_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private int implication;

}