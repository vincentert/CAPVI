package com.project.capvi.model.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public List<Job> getAllJobs() {
		List<Job> jobs = (List<Job>) jobRepository.findAll();
		return jobs;
	}
	
	
}