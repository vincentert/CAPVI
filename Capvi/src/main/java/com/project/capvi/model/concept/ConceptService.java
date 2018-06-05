package com.project.capvi.model.concept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConceptService {
	
	@Autowired
	private ConceptRepository conceptRepository;
	
	public List<Concept> getAllConcepts() {
		List<Concept> concepts = (List<Concept>) conceptRepository.findAll();
		return concepts;
	}
	
	
}