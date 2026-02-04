package com.portfolio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.repository.SkillRepository;

@Service
public class SkillService {
    private final SkillRepository repository;

    public SkillService(SkillRepository repository){
        this.repository = repository;
    }

    public Skill save(Skill skill){
        return repository.save(skill);
    }

    public List<Skill> getAll(){
        return repository.findAll();
    }
}
