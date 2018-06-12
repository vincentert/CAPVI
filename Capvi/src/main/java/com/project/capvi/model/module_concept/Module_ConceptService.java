package com.project.capvi.model.module_concept;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.MajorModuleConceptResult;
import com.project.capvi.model.concept.Concept;
import com.project.capvi.model.concept.ConceptRepository;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.major.MajorRepository;
import com.project.capvi.model.module.Module;
import com.project.capvi.model.module_major.Module_Major;
import com.project.capvi.model.module_major.Module_MajorService;

@Service
public class Module_ConceptService {
	
	@Autowired
	private MajorRepository majorRepository;
	
	@Autowired
	private Module_ConceptRepository module_conceptRepository;

	@Autowired
	private ConceptRepository conceptRepository;
	
	@Autowired
	private Module_MajorService module_majorService;
	
	
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
	
	public ArrayList<Integer> getConceptsBelongLvl(int moduleSelected) {
		ArrayList<Integer> listBelongLvl=new ArrayList<>();	
		Iterable<Module_Concept> allI = module_conceptRepository.findAll();
		Iterator<Module_Concept> allIter = allI.iterator();
		while(allIter.hasNext()) {
			Module_Concept consMod = allIter.next();
			if(consMod.getID_module()==moduleSelected) {
				listBelongLvl.add(consMod.getNiv_att());
			}
		}
			
		return listBelongLvl;
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

	public void join(int[] toModify, int moduleSelected, int[] nivAtt) {
		 Iterable<Module_Concept> allID = module_conceptRepository.findAll();
		 Iterator<Module_Concept> allIDIter = allID.iterator();
		int max=0;
		while(allIDIter.hasNext()) {
			Module_Concept module = allIDIter.next();
			if(module.getID()>max) {
				max=module.getID();
			}	
		}
		int i=0;
		for(int conceptID:toModify) {
			module_conceptRepository.save(new Module_Concept(max+1, moduleSelected,conceptID,nivAtt[i]));
			max++;
			i++;
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
	
	

	public List<MajorModuleConceptResult> result(int[] lvlConcept, int[] conceptID) {
		ArrayList<Integer> conceptIDList=new ArrayList<>();
		ArrayList<MajorModuleConceptResult>returnList=new  ArrayList<>();
		for(int e:conceptID) {
			conceptIDList.add(e);
		}
		List<Major> majors=(List<Major>) majorRepository.findAll();
		for(Major major:majors) {
			 List<Module> modulesVert=new ArrayList<>();
			 List<Module> modulesOrange=new ArrayList<>();
			 List<Module> modulesRouge=new ArrayList<>();
			
			 List<Concept> conceptsVert=new ArrayList<>();
			 List<Concept> conceptsOrange=new ArrayList<>();
			 List<Concept> conceptsRouge=new ArrayList<>();
			int score=0;
			List<Module> modules=module_majorService.getModulesBelong(major.getID());
			for(Module module:modules) {
				ArrayList<Concept> concepts = getConceptsBelong(module.getID());
				ArrayList<Integer> lvls = getConceptsBelongLvl(module.getID());
				int scoreModule=0;
				for(int i=0;i<concepts.size();i++) {
					Concept concept = concepts.get(i);
					Integer lvl = lvls.get(i);
					Integer lvlSelected=lvlConcept[conceptIDList.indexOf(concept.getID())];
					
					
					 
					
					
					if(lvlSelected<lvl-1) {
						conceptsRouge.add(concept);
						
						scoreModule-=2;
					}else if(lvlSelected<lvl) {
						conceptsOrange.add(concept);
						
						scoreModule--;
					}else if(lvl>2&&lvlSelected>lvl) {
						conceptsVert.add(concept);
						
						scoreModule++;
					}else {
						conceptsVert.add(concept);
					}
					
				}
				if(scoreModule>=0 && module_majorService.getModulesBelongOptionalID(major.getID()).contains(module.getID())) {
					score++;
					modulesVert.add(module);
				}else if(scoreModule>=0&&module_majorService.getModulesBelongNonOptionalID(major.getID()).contains(module.getID())){
					score+=3;
					modulesVert.add(module);
				}
				else if(scoreModule>=-2 && module_majorService.getModulesBelongOptionalID(major.getID()).contains(module.getID())) {
					score--;
					modulesOrange.add(module);
				}
				else if(scoreModule>=-2&&module_majorService.getModulesBelongNonOptionalID(major.getID()).contains(module.getID())) {
					score-=2;
					modulesOrange.add(module);
				}
				else if(module_majorService.getModulesBelongOptionalID(major.getID()).contains(module.getID())) {
					score-=1;
					modulesRouge.add(module);
				}else {
					score-=4;
					modulesRouge.add(module);
				}
				
			}
			returnList.add(new MajorModuleConceptResult(major, modulesVert, modulesOrange, modulesRouge, conceptsVert, conceptsOrange, conceptsRouge, score));
			
		}
		Comparator<MajorModuleConceptResult> c=new Comparator<MajorModuleConceptResult>() {

			@Override
			public int compare(MajorModuleConceptResult o1, MajorModuleConceptResult o2) {
				if(o1.getScore()<o2.getScore()) {
					return 1;
				}else {
					return -1;
				}
					
				
			}
		};
		returnList.sort(c);
		return returnList;
		
	}
	

	

	


	
	
	
}