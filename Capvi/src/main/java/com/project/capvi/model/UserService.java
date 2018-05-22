package com.project.capvi.model;

public class UserService {

	
	
	public User loginCustomer(String login, String password) {	
		
		return new User(login,password);
	}
}
