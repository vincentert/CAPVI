package com.project.capvi.model.requirement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Requirement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String field;
	private int value;
	private int ID_module;
	
	
	public Requirement() {
		
	}
	
	
	public Requirement(int iD, String field, int value, int ID_module) {
		
		super();
		ID = iD;
		this.field = field;
		this.value = value;
		this.ID_module = ID_module;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getID_module() {
		return ID_module;
	}


	public void setID_module(int iD_module) {
		ID_module = iD_module;
	}
	
	
	
}
