package com.project.capvi.model.major;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService {
	
	@Autowired
	private MajorRepository majorRepository;
	
	public List<Major> getAllMajors() {
		List<Major> majors = (List<Major>) majorRepository.findAll();
		return majors;
	}
	
	public int addMajors(String name,String description) {
		if(name==null||description==null||name.equals("")||description.equals("")) {
			return -1;
		}
		List<Major> majors = (List<Major>) majorRepository.findAll();
		List<Integer> ids=new ArrayList<>();
		for(Major major:majors) {
			ids.add(major.getID());
		}
		int i=ids.size();
		while(ids.contains(i)) {
			i++;
		}
		majorRepository.save(new Major(i,name,description));
		return 1;
	}
	
	public Major getMajorById(int id) {
		return majorRepository.findById(id).get();
	}
	

}