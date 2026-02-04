package com.portfolio.backend.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.service.SkillService;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {
    private final SkillService service;

    public SkillController (SkillService service){
        this.service = service;
    }
    public  Skill create(@RequestBody Skill skill){
        return service.save(skill);
    }

    public  List<Skill> getAll(){
    return service.getAll();
    }
}
