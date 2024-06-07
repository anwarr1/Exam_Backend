package org.example.exam_backend.repository;

import org.example.exam_backend.models.Person;
import org.example.exam_backend.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
