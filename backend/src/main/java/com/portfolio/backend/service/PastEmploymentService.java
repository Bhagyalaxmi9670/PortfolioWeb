package com.portfolio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.PastEmployment;
import com.portfolio.backend.repository.PastEmploymentRepository;

@Service
public class PastEmploymentService {

    private final PastEmploymentRepository repository;

    public PastEmploymentService(PastEmploymentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public PastEmployment save(PastEmployment employment) {
        return repository.save(employment);
    }

    // READ
    public List<PastEmployment> getAll() {
        return repository.findAll();
    }

    // UPDATE ✅
    public PastEmployment updateEmployment(Long id, PastEmployment updatedEmployment) {

        PastEmployment existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Employment not found with id " + id));

        // Update fields (adjust names as per your entity)
        existing.setCompanyName(updatedEmployment.getCompanyName());
        existing.setRole(updatedEmployment.getRole());
        existing.setStartYear(updatedEmployment.getStartYear());
        existing.setEndYear(updatedEmployment.getEndYear());
        existing.setDescription(updatedEmployment.getDescription());

        return repository.save(existing);
    }

    // DELETE ✅
    public void deleteEmployment(Long id) {
        repository.deleteById(id);
    }
}
