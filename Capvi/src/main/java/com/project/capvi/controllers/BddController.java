package com.project.capvi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.capvi.model.concept.Concept;
import com.project.capvi.model.concept.ConceptService;
import com.project.capvi.model.job.Job;
import com.project.capvi.model.job.JobService;
import com.project.capvi.model.job_major.Job_MajorService;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.major.MajorService;
import com.project.capvi.model.module.Module;
import com.project.capvi.model.module.ModuleService;
import com.project.capvi.model.module_concept.Module_ConceptService;
import com.project.capvi.model.module_major.Module_MajorService;
import com.project.capvi.model.requirement.Requirement;
import com.project.capvi.model.requirement.RequirementService;
import com.project.capvi.model.user.User;
import com.project.capvi.model.user.UserService;

@RestController
public class BddController {
	
	@Autowired
	private UserService userService;
	private JobService jobService;
	private MajorService majorService;
	private ModuleService moduleService;
	private ConceptService conceptService;
	private RequirementService requirementService;
	private Job_MajorService job_majorService;
	private Module_ConceptService module_conceptService;
	private Module_MajorService module_majorService;
	
	// Renvoie list users et autres tables
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/jobs")
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}
	
	@GetMapping("/majors")
	public List<Major> getAllMajors() {
		return majorService.getAllMajors();
	}
	
	@GetMapping("/modules")
	public List<Module> getAllModules() {
		return moduleService.getAllModules();
	}
	
	@GetMapping("/concepts")
	public List<Concept> getAllConcepts() {
		return conceptService.getAllConcepts();
	}

	@GetMapping("/requirements")
	public List<Requirement> getAllRequirements() {
		return requirementService.getAllRequirements();
	}
}
