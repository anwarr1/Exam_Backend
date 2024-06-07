package org.example.exam_backend.repository;

import org.example.exam_backend.models.Affectation;
import org.example.exam_backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffectationRepository  extends JpaRepository<Affectation, Long> {
}
