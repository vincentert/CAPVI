package com.project.capvi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.capvi.model.User;
import com.project.capvi.model.UserService;

@RestController
public class BddController {
	
	@Autowired
	private UserService userService;
	
	// Renvoie list users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
