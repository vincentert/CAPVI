package com.project.capvi.model.job_major;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capvi.model.job.Job;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.major.MajorRepository;

@Service
public class Job_MajorService {
	
	@Autowired
	private Job_MajorRepository job_majorRepository;
	
	@Autowired
	private MajorRepository majorRepository;
	
	public ArrayList<String> getMajorLinkedToJob(String job) {
		int jobInt = Integer.parseInt(job);
		Iterable<Job_Major> majors = job_majorRepository.findAll();
		Iterator<Job_Major> majorIter = majors.iterator();
		ArrayList <String> listMajor= new ArrayList<>();
		while (majorIter.hasNext()) {
			Job_Major maj = majorIter.next();
			if (maj.getID_job()==jobInt) {
				listMajor.add(majorRepository.findById(maj.getID_major()).get().getName());
			}
		}
		
		return listMajor;
		
	}
}