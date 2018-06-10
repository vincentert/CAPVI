package com.project.capvi.model.module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.major.Major;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	public List<Module> getAllModules() {
		List<Module> modules = (List<Module>) moduleRepository.findAll();
		return modules;
	}

	public Module getModuleById(int moduleSelected) {
		return moduleRepository.findById(moduleSelected).get();
		
	}

	public int addModule(String name, String description) {
		if(name==null||description==null||name.equals("")||description.equals("")) {
			return -1;
		}
		Iterator<Module> modules = moduleRepository.findAll().iterator();
		List<Integer> ids=new ArrayList<>();
		while (modules.hasNext()) {
			Module module = modules.next();
			ids.add(module.getID());
		}
		int i=ids.size();
		while(ids.contains(i)) {
			i++;
		}
		moduleRepository.save(new Module(i,name,description));
		return 1;
		
	}
	
	
	
	
}