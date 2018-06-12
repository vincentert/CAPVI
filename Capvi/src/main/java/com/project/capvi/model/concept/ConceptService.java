package com.project.capvi.model.concept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.major.Major;

@Service
public class ConceptService {
	
	@Autowired
	private ConceptRepository conceptRepository;
	
	public List<Concept> getAllConcepts() {
		List<Concept> concepts = (List<Concept>) conceptRepository.findAll();
		return concepts;
	}

	public int addConcept(String name, String description) {
		if(name==null||description==null||name.equals("")||description.equals("")) {
			return -1;
		}
		List<Concept> majors = (List<Concept>) conceptRepository.findAll();
		List<Integer> ids=new ArrayList<>();
		for(Concept major:majors) {
			ids.add(major.getID());
		}
		int i=ids.size();
		while(ids.contains(i)) {
			i++;
		}
		conceptRepository.save(new Concept(i,name,description));
		return 1;
	}
	
}