package com.project.capvi.model.module_concept;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.concept.Concept;
import com.project.capvi.model.concept.ConceptRepository;
import com.project.capvi.model.module.Module;
import com.project.capvi.model.module_major.Module_Major;

@Service
public class Module_ConceptService {
	
	@Autowired
	private Module_ConceptRepository module_conceptRepository;

	@Autowired
	private ConceptRepository conceptRepository;
	
	public ArrayList<Concept> getConceptsBelong(int moduleSelected) {
		ArrayList<Concept> listBelong=new ArrayList<>();	
		Iterable<Module_Concept> allI = module_conceptRepository.findAll();
		Iterator<Module_Concept> allIter = allI.iterator();
		while(allIter.hasNext()) {
			Module_Concept consMod = allIter.next();
			if(consMod.getID_module()==moduleSelected) {
				listBelong.add(conceptRepository.findById(consMod.getID_concept()).get());
			}
		}
			
		return listBelong;
	}

	public ArrayList<Concept> getConceptsNotBelong(int moduleSelected) {
		ArrayList<Concept> listBelong=new ArrayList<>();	
		ArrayList<Concept> listNotBelong=new ArrayList<>();	
		Iterable<Module_Concept> allI = module_conceptRepository.findAll();
		Iterator<Module_Concept> allIter = allI.iterator();
		while(allIter.hasNext()) {
			Module_Concept consMod = allIter.next();
			if(consMod.getID_module()==moduleSelected) {
				listBelong.add(conceptRepository.findById(consMod.getID_concept()).get());
			}
		}
		Iterator<Concept> listConceptIter = conceptRepository.findAll().iterator();
		while(listConceptIter.hasNext()) {
			Concept concept = listConceptIter.next();
			if(!listBelong.contains(concept)) {
				listNotBelong.add(concept);
			}
		}
		
		return listNotBelong;
	}

	public void join(int[] toModify, int moduleSelected) {
		 Iterable<Module_Concept> allID = module_conceptRepository.findAll();
		 Iterator<Module_Concept> allIDIter = allID.iterator();
		int max=0;
		while(allIDIter.hasNext()) {
			Module_Concept module = allIDIter.next();
			if(module.getID()>max) {
				max=module.getID();
			}	
		}
		
		for(int conceptID:toModify) {
			module_conceptRepository.save(new Module_Concept(max+1, moduleSelected,conceptID));
			max++;
		}
		
	}

	public void delete(int[] toDelete, int moduleSelected) {
		
		ArrayList<Integer> idToDel=new ArrayList<>();
		 Iterable<Module_Concept> all = module_conceptRepository.findAll();
		 Iterator<Module_Concept> allIter = all.iterator();
		while(allIter.hasNext()) {
			 Module_Concept modMaj = allIter.next();
			for(int modToDel:toDelete) {
				if(moduleSelected==modMaj.getID_module()&&modToDel==modMaj.getID_concept()) {
					idToDel.add(modMaj.getID());
				}
			}
			
		}
		for(Integer id:idToDel) {
			module_conceptRepository.deleteById(id);
		}
		
	}
	

	

	


	
	
	
}