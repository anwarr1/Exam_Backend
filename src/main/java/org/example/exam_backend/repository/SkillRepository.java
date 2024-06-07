package org.example.exam_backend.repository;

import org.example.exam_backend.models.Employee;
import org.example.exam_backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
