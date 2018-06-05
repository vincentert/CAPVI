package com.project.capvi.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	
	public User loginCustomer(String login, String password) {	
		
		return new User();
	}
}
