package com.project.capvi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.capvi.model.User;
import com.project.capvi.model.UserService;


@Controller
public class PageController {
	@GetMapping("/")
	public String home(@RequestParam(required = false, defaultValue="World") String name, ModelMap modelMap) {
		modelMap.put("name",name);
		return "pages/index";
	}
	
	
	
	
//	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		User user = userService.loginCustomer(userId, password);
		if (user==null) {
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "login";
		}
		session.setAttribute("loggedInUser", user);
		return "redirect:/";
	}


}

