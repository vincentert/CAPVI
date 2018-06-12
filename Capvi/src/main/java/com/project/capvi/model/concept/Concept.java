package com.project.capvi.model.concept;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Concept implements Serializable{
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String name;
	private String description;
	
	public Concept() {
		
	}
	
	public Concept(int iD, String name, String description) {
		
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
}
