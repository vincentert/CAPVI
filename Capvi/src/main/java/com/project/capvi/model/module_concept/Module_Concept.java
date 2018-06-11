package com.project.capvi.model.module_concept;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Module_Concept {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private int ID_module;
	private int ID_concept;
	private int niv_att;
	public Module_Concept() {
		
	}
	
	public Module_Concept(int iD, int ID_module, int ID_concept,int niv_att) {
		
		super();
		ID = iD;
		this.ID_module = ID_module;
		this.ID_concept = ID_concept;
		this.niv_att=niv_att;
		
	}

	

	public int getNiv_att() {
		return niv_att;
	}

	public void setNiv_att(int niv_att) {
		this.niv_att = niv_att;
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

	public int getID_concept() {
		return ID_concept;
	}

	public void setID_concept(int iD_concept) {
		ID_concept = iD_concept;
	}

	
}
