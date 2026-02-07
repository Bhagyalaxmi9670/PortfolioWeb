package com.portfolio.backend.controller;

import com.portfolio.backend.entity.PastEmployment;

import com.portfolio.backend.service.PastEmploymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employment")
@CrossOrigin(origins = "http://localhost:4200")
public class PastEmploymentController {

    private final PastEmploymentService service;

    public PastEmploymentController(PastEmploymentService service) {
        this.service = service;
    }

    @PostMapping
    public PastEmployment create(@RequestBody PastEmployment employment) {
        return service.save(employment);
    }

    @GetMapping
    public List<PastEmployment> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PastEmployment update(
        @PathVariable Long id,
        @RequestBody PastEmployment employment
    ){
        return service.updateEmployment(id, employment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
service.deleteEmployment(id);
    }
}
