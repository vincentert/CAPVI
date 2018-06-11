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
import com.project.capvi.model.concept.ConceptService;
import com.project.capvi.model.job.JobService;
import com.project.capvi.model.job_major.Job_MajorService;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.major.MajorService;
import com.project.capvi.model.module.ModuleService;
import com.project.capvi.model.module_concept.Module_ConceptService;
import com.project.capvi.model.module_major.Module_MajorService;
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
	@Autowired
	private Job_MajorService job_majorService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private ConceptService conceptService;
	@Autowired
	private Module_ConceptService module_conceptService;
	@Autowired
	private Module_MajorService module_majorService;
	@GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("metier_preselect", "Choisissez un metier");
		model.addAttribute("messages", jobService.getAllJobsTabStringID());
		model.addAttribute("message", jobService.getAllJobsTabString());
		return "pages/index";
	};
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homepostform(Model model, @RequestParam String metier) {
		model.addAttribute("majors",  job_majorService.getMajorLinkedToJob(metier));
		model.addAttribute("metier_preselect", jobService.getName(Integer.parseInt(metier)));
		model.addAttribute("messages", jobService.getAllJobsTabStringID());
		model.addAttribute("message", jobService.getAllJobsTabString());
		return "pages/index";
	};
	
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
	@RequestMapping(value = "/addModule", method = RequestMethod.GET)
	public String addModuleVerifAdmin(HttpSession session) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user!=null&&user.isAdmin()) {
			return "pages/addModule";
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
		return "redirect:/AccueilAdmin";
		
	}
	@RequestMapping(value = "/addConcept", method = RequestMethod.GET)
	public String addConcept(HttpSession session) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user!=null&&user.isAdmin()) {
			return "pages/addConcept";
		}else {
			System.out.println("Acces refusé");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/addConcept", method = RequestMethod.POST)
	public String addConcept(HttpSession session,@RequestParam String name, @RequestParam String description) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user==null||!user.isAdmin()) {
			return "redirect:/";
		}
		conceptService.addMajors(name, description);
		return "redirect:/AccueilAdmin";
		
	}
	
	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public String addModule(HttpSession session,@RequestParam String name, @RequestParam String description) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user==null||!user.isAdmin()) {
			return "redirect:/";
		}
		moduleService.addModule(name, description);
		return "redirect:/AccueilAdmin";	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "pages/login";
	}
	@RequestMapping(value = "/AccueilAdmin", method = RequestMethod.GET)
	public String verifAdmin(HttpSession session) {
		User user = (User) session.getAttribute(LOGGEDUSER);
		if(user!=null&&user.isAdmin()) {
			session.setAttribute("majors", majorService.getAllMajors());
			session.setAttribute("modules", moduleService.getAllModules());
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
		else if (!user.isAdmin()) {
			return "redirect:/choixquestionnaire";

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
	@RequestMapping(value = "/modifyMajor", method = RequestMethod.POST)
	public String postModifyMajor(@RequestParam int majorSelected, Model model) {
		model.addAttribute("major", majorService.getMajorById(majorSelected));
		model.addAttribute("modulesBelong",module_majorService.getModulesBelong(majorSelected) );
		model.addAttribute("modulesNotBelong", module_majorService.getModulesNotBelong(majorSelected));
		return "pages/modifyMajor";
	}
	@RequestMapping(value = "/modifyMajor2", method = RequestMethod.POST)
	public String postModifyMajor2(@RequestParam int majorSelected, Model model,@RequestParam int[] toModify ) {
		
		module_majorService.join(toModify, majorSelected);
		model.addAttribute("major", majorService.getMajorById(majorSelected));
		model.addAttribute("modulesBelong",module_majorService.getModulesBelong(majorSelected) );
		model.addAttribute("modulesNotBelong", module_majorService.getModulesNotBelong(majorSelected));
		return "pages/modifyMajor";
	}
	@RequestMapping(value = "/modifyMajor3", method = RequestMethod.POST)
	public String postModifyMajor3(@RequestParam int majorSelected, Model model,@RequestParam int[] toDelete ) {
		
		module_majorService.delete(toDelete, majorSelected);
		model.addAttribute("major", majorService.getMajorById(majorSelected));
		model.addAttribute("modulesBelong",module_majorService.getModulesBelong(majorSelected) );
		model.addAttribute("modulesNotBelong", module_majorService.getModulesNotBelong(majorSelected));
		return "pages/modifyMajor";
	}
	
	@RequestMapping(value = "/modifyModule", method = RequestMethod.POST)
	public String postModifyModule(@RequestParam int moduleSelected, Model model ) {
		model.addAttribute("module", moduleService.getModuleById(moduleSelected));
		model.addAttribute("conceptsBelong",module_conceptService.getConceptsBelong(moduleSelected) );
		model.addAttribute("conceptsNotBelong", module_conceptService.getConceptsNotBelong(moduleSelected));
		return "pages/modifyModule";   
	}
	@RequestMapping(value = "/modifyModule2", method = RequestMethod.POST)
	public String postModifyModule2(@RequestParam int moduleSelected, Model model,@RequestParam int[] toModify) {
		
		module_conceptService.join(toModify, moduleSelected);
		model.addAttribute("module", moduleService.getModuleById(moduleSelected));
		model.addAttribute("conceptsBelong",module_conceptService.getConceptsBelong(moduleSelected) );
		model.addAttribute("conceptsNotBelong", module_conceptService.getConceptsNotBelong(moduleSelected));
		return "pages/modifyModule";   
	}
	@RequestMapping(value = "/modifyModule3", method = RequestMethod.POST)
	public String postModifyModule3(@RequestParam int moduleSelected, Model model,@RequestParam int[] toDelete) {
	
		module_conceptService.delete(toDelete, moduleSelected);
		model.addAttribute("module", moduleService.getModuleById(moduleSelected));
		model.addAttribute("conceptsBelong",module_conceptService.getConceptsBelong(moduleSelected) );
		model.addAttribute("conceptsNotBelong", module_conceptService.getConceptsNotBelong(moduleSelected));
		return "pages/modifyModule";   
	}

	
	
	

}

