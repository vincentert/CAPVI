package com.project.capvi.model.major;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Major {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String name;
	private String description;
	
	
	public Major() {
		
	}
	
public Major(int iD, String name, String description) {
		
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
