package org.example.exam_backend.repository;

import org.antlr.v4.runtime.atn.SemanticContext;
import org.example.exam_backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
