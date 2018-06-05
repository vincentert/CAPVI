package com.project.capvi.controllers;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.capvi.model.ConnexionBdd;
import com.project.capvi.model.job.JobService;
import com.project.capvi.model.user.User;
import com.project.capvi.model.user.UserService;


@Controller
public class PageController {

	@Autowired
	private UserService userService;
	private JobService jobService;

	@GetMapping("/")
	public String home(@RequestParam(required = false, defaultValue="World") String name, ModelMap modelMap) {
		modelMap.put("name",name);
		return "pages/index";
	}


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		Connection co = ConnexionBdd.getInstance().conn;

		return "pages/index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(HttpSession session) {
		if(isAlreadyConnected(session)) {
			
			return "pages/index";
		}
		return "pages/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		if(isAlreadyConnected(session)) {
			return "pages/index";
		}
		User user = userService.loginCustomer(userId, password);
		if (user==null) {
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "pages/login";
		}
		session.setAttribute("loggedInUser", user.getID());
		return "pages/index";
	}

	public boolean isAlreadyConnected(HttpSession session) {

		if(session.getAttribute("loggedInUser")!=null) {
			System.out.println("already connected");
			return true;
		}

		return false;

	}



	@RequestMapping(value = "/choixquestionnaire", method = RequestMethod.GET)
	public String showchoixquestForm() {
		return "pages/choixquestionnaire";
	}
	
	@RequestMapping(value = "/questmodul", method = RequestMethod.GET)
	public String showquestmodulForm() {
		return "pages/questmodul";
	}
	
	@RequestMapping(value = "/questprereq", method = RequestMethod.GET)
	public String showquestprereqForm() {
		return "pages/questprereq";
	}

}

