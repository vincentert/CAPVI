package com.project.capvi.model.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	public List<Module> getAllModules() {
		List<Module> modules = (List<Module>) moduleRepository.findAll();
		return modules;
	}
	
	
}