package org.example.exam_backend.service;

import org.example.exam_backend.models.Affectation;
import org.example.exam_backend.repository.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationService {
    AffectationRepository affectationRepository;

    @Autowired
    public AffectationService(AffectationRepository affectationRepository) {
        this.affectationRepository = affectationRepository;
    }

    public List<Affectation> getAll() {
        return affectationRepository.findAll();
    }

    public void save(Affectation aff) {
        affectationRepository.save(aff);
    }

    public Optional<Affectation> findById(Long id) {
        return affectationRepository.findById(id);
    }

    public void addAffectation(Affectation affectation) {
        affectationRepository.save(affectation);
    }

    public void deleteAffectation(Long id) {
        affectationRepository.deleteById(id);
    }
}
