package com.project.capvi.model.module_major;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module_Major {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private int ID_module;
	private int ID_major;

	public Module_Major() {
		
	}
	
	public Module_Major(int iD, int ID_module, int ID_major) {
		
		super();
		ID = iD;
		this.ID_module = ID_module;
		this.ID_major = ID_major;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_module() {
		return ID_module;
	}

	public void setID_module(int iD_module) {
		ID_module = iD_module;
	}

	public int getID_major() {
		return ID_major;
	}

	public void setID_major(int iD_major) {
		ID_major = iD_major;
	}
	
	

}
