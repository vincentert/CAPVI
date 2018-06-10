package com.project.capvi.model.module_major;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.module.Module;
import com.project.capvi.model.module.ModuleRepository;

@Service
public class Module_MajorService {
	
	@Autowired
	private Module_MajorRepository module_majorRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	
	
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
	
	public void join(int[] modulesID,int majorID) {
		for(int moduleID:modulesID) {
			module_majorRepository.save(new Module_Major(0, moduleID, majorID));
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
	
}