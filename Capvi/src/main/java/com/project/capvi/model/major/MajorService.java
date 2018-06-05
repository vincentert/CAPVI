package com.project.capvi.model.major;

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
	

}