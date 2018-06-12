package com.project.capvi.model.module_major;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.MajorModuleResult;
import com.project.capvi.model.concept.Concept;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.major.MajorRepository;
import com.project.capvi.model.module.Module;
import com.project.capvi.model.module.ModuleRepository;

@Service
public class Module_MajorService {
	
	@Autowired
	private Module_MajorRepository module_majorRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private MajorRepository majorRepository;
	
	
	public ArrayList<Module> getModulesBelong(int majID){
		ArrayList<Module> listMod=new ArrayList<>();
		Iterable<Module_Major> allModMaj = module_majorRepository.findAll();
		Iterator<Module_Major> allModMajIter = allModMaj.iterator();
		while(allModMajIter.hasNext()) {
			 Module_Major modMaj = allModMajIter.next();
			 if(modMaj.getID_major()==majID) {
				 listMod.add(moduleRepository.findById(modMaj.getID_module()).get());
			 }
		}
		return listMod;
	}
	
	public ArrayList<Module> getModulesBelongOptional(int majID){
		ArrayList<Module> listMod=new ArrayList<>();
		Iterable<Module_Major> allModMaj = module_majorRepository.findAll();
		Iterator<Module_Major> allModMajIter = allModMaj.iterator();
		while(allModMajIter.hasNext()) {
			 Module_Major modMaj = allModMajIter.next();
			 if(modMaj.getID_major()==majID&&modMaj.isOption()) {
				 listMod.add(moduleRepository.findById(modMaj.getID_module()).get());
			 }
		}
		return listMod;
	}
	public ArrayList<Module> getModulesBelongNonOptional(int majID){
		ArrayList<Module> listMod=new ArrayList<>();
		Iterable<Module_Major> allModMaj = module_majorRepository.findAll();
		Iterator<Module_Major> allModMajIter = allModMaj.iterator();
		while(allModMajIter.hasNext()) {
			 Module_Major modMaj = allModMajIter.next();
			 if(modMaj.getID_major()==majID&&!modMaj.isOption()) {
				 listMod.add(moduleRepository.findById(modMaj.getID_module()).get());
			 }
		}
		return listMod;
	}
	
	public ArrayList<Module> getModulesNotBelong(int majID){
		ArrayList<Module> listMod=new ArrayList<>();
		ArrayList<Module> listNotMod=new ArrayList<>();
		Iterable<Module_Major> allModMaj = module_majorRepository.findAll();
		Iterator<Module_Major> allModMajIter = allModMaj.iterator();
		while(allModMajIter.hasNext()) {
			 Module_Major modMaj = allModMajIter.next();
			 if(modMaj.getID_major()==majID) {
				 listMod.add(moduleRepository.findById(modMaj.getID_module()).get());
			 }
		}
		Iterable<Module> listModule = moduleRepository.findAll();
		Iterator<Module> it = listModule.iterator();
		while(it.hasNext()) {
			Module mod = it.next();
			if(!listMod.contains(mod)) {
				listNotMod.add(mod);
			}
		}
		return listNotMod;
	}
	
	public void join(int[] modulesID,int majorID, int[] optionModule) {
		ArrayList<Integer> optionModuleId=new ArrayList<>();
		if(optionModule!=null) {
			for(int e:optionModule) {
				optionModuleId.add(e);
			}
		}
		
		Iterable<Module_Major> allID = module_majorRepository.findAll();
		Iterator<Module_Major> allIDIter = allID.iterator();
		int max=0;
		while(allIDIter.hasNext()) {
			Module_Major module = allIDIter.next();
			if(module.getID()>max) {
				max=module.getID();
			}	
		}
		
		
		
		for(int moduleID:modulesID) {
			if(optionModuleId!=null&&optionModuleId.contains(moduleID)) {
				module_majorRepository.save(new Module_Major(max+1, moduleID, majorID,true));
			}else {
				module_majorRepository.save(new Module_Major(max+1, moduleID, majorID,false));
			}
			max++;
		}
	}
	public void delete(int[] toDelete, int majorSelected) {
		ArrayList<Integer> idToDel=new ArrayList<>();
		Iterable<Module_Major> all = module_majorRepository.findAll();
		Iterator<Module_Major> allIter = all.iterator();
		while(allIter.hasNext()) {
			Module_Major modMaj = allIter.next();
			for(int modToDel:toDelete) {
				if(majorSelected==modMaj.getID_major()&&modToDel==modMaj.getID_module()) {
					idToDel.add(modMaj.getID());
				}
			}
			
		}
		for(Integer id:idToDel) {
			module_majorRepository.deleteById(id);
		}
	}
	public ArrayList<MajorModuleResult> result(int[] choixModule, int[] moduleID) {
		ArrayList<MajorModuleResult> returnList=new ArrayList<>();
		ArrayList<Integer> moduleListChoix=new ArrayList<>();
		for(int choix:choixModule) {
			moduleListChoix.add(choix);
		}
		ArrayList<Integer> moduleIDList=new ArrayList<>();
		for(int idmod:moduleID) {
			moduleIDList.add(idmod);
		}
		ArrayList<Integer> iDmoduleVoulu=new ArrayList<>();
		ArrayList<Integer> iDmoduleNonVoulu=new ArrayList<>();
		
		for(int i=0;i<choixModule.length;i++) {
			if(choixModule[i]==3) {
				iDmoduleVoulu.add(moduleID[i]);
			}else if(choixModule[i]==2) {
				iDmoduleNonVoulu.add(moduleID[i]);
			}
		}
		List<Major> majors = (List<Major>) majorRepository.findAll();
		
		for(Major major:majors) {
			int score=0;
			ArrayList<Module> modulesOptionel = getModulesBelongOptional(major.getID());
			ArrayList<Module> modulesNonOptionel = getModulesBelongNonOptional(major.getID());
			
			 List<Module> modulesVoulusOptionel=new ArrayList<>();
			 List<Module> modulesVoulusNonOptionel=new ArrayList<>();
			 List<Module> modulesNonVoulusOptionel=new ArrayList<>();
			 List<Module> modulesNonVoulusNonOptionel=new ArrayList<>();
			
			for(Module moduleOptionel:modulesOptionel) {
				int s = choixModule[moduleIDList.indexOf(moduleOptionel.getID())];
				if(s==1) {
					modulesNonVoulusOptionel.add(moduleOptionel);
					score-=1;
				}else if(s==3){
					modulesVoulusOptionel.add(moduleOptionel);
					score+=1;
				}
			}
			for(Module moduleNonOptionel:modulesNonOptionel) {
				int s = choixModule[moduleIDList.indexOf(moduleNonOptionel.getID())];
				if(s==1) {
					modulesNonVoulusNonOptionel.add(moduleNonOptionel);
					score-=3;
				}else if(s==3){
					modulesVoulusNonOptionel.add(moduleNonOptionel);
					score+=3;
				}
			}
			
			returnList.add(new MajorModuleResult(major, modulesOptionel, moduleListChoix, modulesNonOptionel, score,
					modulesVoulusOptionel,modulesVoulusNonOptionel,modulesNonVoulusOptionel,modulesNonVoulusNonOptionel));
		}
		Comparator<MajorModuleResult> c=new Comparator<MajorModuleResult>() {

			@Override
			public int compare(MajorModuleResult o1, MajorModuleResult o2) {
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