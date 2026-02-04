package com.portfolio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Project;
import com.portfolio.backend.repository.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository repository;
	
	public ProjectService(ProjectRepository repository) {
		this.repository = repository;
	}
	
	public Project saveProject(Project project) {
		return repository.save(project);
		
	}
	public List<Project> getAllProjects(){
		return repository.findAll();
		
	}
	public Project updateProject(Long id,Project updatedProject) {
		Project existingProject = repository.findById(id)
		.orElseThrow(()-> new RuntimeException("Project not found with id" +id));

		existingProject.setTitle(updatedProject.getTitle());
		existingProject.setDescription(updatedProject.getDescription());
		existingProject.setTechStack(updatedProject.getTechStack());

		return repository.save(existingProject);
	}
	
	public void deleteProject(Long id) {
		repository.deleteById(id);
	}
	
}
