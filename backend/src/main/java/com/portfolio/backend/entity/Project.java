package com.portfolio.backend.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 private String title;
 private String description;
 private String techStack;
 
 @ManyToOne
 @JoinColumn(name ="client_id")
 private Client client;

 @ManyToMany
 @JoinTable(
	name = "project_skill",
	joinColumns = @JoinColumn(name ="project_id"),
	inverseJoinColumns = @JoinColumn(name ="skill_id")
 )
 private List<Skill> skills;


 public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
	
 public Long getId() {
	return id;
 }

 public void setId(Long id) {
	this.id = id;
 }

 public String getTitle() {
	return title;
 }

 public void setTitle(String title) {
	this.title = title;
 }

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public String getTechStack() {
	return techStack;
 }

 public void setTechStack(String techStack) {
	this.techStack = techStack;
 }

 public Client getClient() {
	return client;
 }

 public void setClient(Client client) {
	this.client = client;
 }


 
 
}
