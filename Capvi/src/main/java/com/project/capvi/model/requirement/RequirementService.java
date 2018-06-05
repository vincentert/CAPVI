package com.project.capvi.model.requirement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	public List<Requirement> getAllRequirements() {
		List<Requirement> requirements = (List<Requirement>) requirementRepository.findAll();
		return requirements;
	}
	
}