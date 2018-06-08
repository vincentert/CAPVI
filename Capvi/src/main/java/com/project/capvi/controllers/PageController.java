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
import com.project.capvi.model.major.MajorService;
import com.project.capvi.model.user.User;
import com.project.capvi.model.user.UserService;


@Controller
public class PageController {
	public static final String LOGGEDUSER="loggedInUser";
	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	@Autowired
	private MajorService majorService;
	@GetMapping("/")
	public String home(@RequestParam(required = false, defaultValue="World") String name, ModelMap modelMap, Model model) {
		
		
		model.addAttribute("message", jobService.getAllJobsTabString());
		modelMap.put("name",name);
		return "pages/index";
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		
		Connection co = ConnexionBdd.getInstance().conn;

		return "pages/index";
		
	}
	
	@RequestMapping(value = "/addMajor", method = RequestMethod.GET)
	public String addMajorVerifAdmin(HttpSession session) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user!=null&&user.isAdmin()) {
			return "pages/addMajor";
		}else {
			System.out.println("Acces refusé");
			return "redirect:/";
		}
		
	}
	
	
	@RequestMapping(value = "/addMajor", method = RequestMethod.POST)
	public String addMajor(HttpSession session,@RequestParam String name, @RequestParam String description) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user==null||!user.isAdmin()) {
			return "redirect:/";
		}
		majorService.addMajors(name, description);
		return "pages/addMajor";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "pages/login";
	}
	@RequestMapping(value = "/AccueilAdmin", method = RequestMethod.GET)
	public String verifAdmin(HttpSession session) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user!=null&&user.isAdmin()) {
			return "pages/AccueilAdmin";
		}else {
			System.out.println("Acces refusé");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		User user = userService.loginCustomer(userId, password);
		if (user==null) {
			model.addAttribute("loginError", "Error logging in. Please try again");
			return "pages/login";
		}
		session.setAttribute(LOGGEDUSER, user);
		System.out.println("Connected");
		if(user.isAdmin()) {
			return "redirect:/AccueilAdmin";
		}
		return "redirect:/";
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

