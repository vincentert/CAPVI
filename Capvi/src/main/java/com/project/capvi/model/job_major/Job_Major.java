package com.project.capvi.model.job_major;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job_Major {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private int ID_job;
	private int ID_major;

	public Job_Major() {
		
	}
	
	public Job_Major(int iD, int ID_job, int ID_major) {
		
		super();
		ID = iD;
		this.ID_job = ID_job;
		this.ID_major = ID_major;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_job() {
		return ID_job;
	}

	public void setID_job(int iD_job) {
		ID_job = iD_job;
	}

	public int getID_major() {
		return ID_major;
	}

	public void setID_major(int iD_major) {
		ID_major = iD_major;
	}
	
	
	
}
