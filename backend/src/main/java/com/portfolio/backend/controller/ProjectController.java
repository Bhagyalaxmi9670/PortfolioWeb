 package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.entity.Project;
import com.portfolio.backend.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200")


public class ProjectController {
	private final ProjectService service;
	
	public ProjectController(ProjectService service) {
		this.service = service;
	}
	
	@PostMapping
	public Project create(@RequestBody Project project) {
		return service.saveProject(project);
	}
	
	@GetMapping
	public List<Project> getAll(){
		return service.getAllProjects();
		
	}
	@PutMapping("/{id}")
	public Project update(@PathVariable Long id,@RequestBody Project project){
		return service.updateProject(id, project);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteProject(id);
	}
}
