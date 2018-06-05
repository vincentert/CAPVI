package com.project.capvi.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String email;
	private String password;
	private String name;
	private boolean admin;
	private String status;
	
	public User() {
		
	}
	
	public User(int iD, String email, String password, String name, boolean admin, String status) {
		super();
		ID = iD;
		this.email = email;
		this.password = password;
		this.name = name;
		this.admin = admin;
		this.status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
