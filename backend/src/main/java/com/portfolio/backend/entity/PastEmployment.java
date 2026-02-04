package com.portfolio.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PastEmployment {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 private String companyName;
 private String role;
 private String startYear;
 private String endYear;
 private String description;
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 public String getCompanyName() {
	return companyName;
 }
 public void setCompanyName(String companyName) {
	this.companyName = companyName;
 }
 public String getRole() {
	return role;
 }
 public void setRole(String role) {
	this.role = role;
 }
 public String getStartYear() {
	return startYear;
 }
 public void setStartYear(String startYear) {
	this.startYear = startYear;
 }
 public String getEndYear() {
	return endYear;
 }
 public void setEndYear(String endYear) {
	this.endYear = endYear;
 }
	
  public String getDescription() {
	return description;
 }
 public void setDescription(String description) {
	this.description = description;
 }
	
 
	
}
