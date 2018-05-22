package com.project.capvi.model;

public class User {
	private String login;
	private String password;
	private String name;
	
	User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	User(String login, String password, String name) {
		this.login = login;
		this.password = password;
		this.name = name;
	}
}
