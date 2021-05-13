package com.furkancelik.deneme.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.furkancelik.deneme.model.Education;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.EducationService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class EducationController {

	@Autowired
	UserService userService;
	
	@Autowired
	EducationService educationService;
	
	@GetMapping("/user/edu")
	public String edu(Model model, Authentication authentication)
	{
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Collection<Education> educations = educationService.findAllByUserId(user.getId());
		model.addAttribute("educations", educations);
		return "edu";
	}
	
	
	@GetMapping("/user/addedu")
	public String addEdu(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("edu", new Education());
		model.addAttribute("user", user);
		return "addedu";
	}
	
	
	@PostMapping("/user/newedu")
	public RedirectView addEdu(Authentication authentication, @ModelAttribute Education education)
	{
		User user = getCurrentUser(authentication);
		user.getEducations().add(education);
		userService.createUser(user);
		return new RedirectView("/user/edu");
		
	}
	
	@GetMapping("/user/edudetail")
	public String eduDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Education education = educationService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("education", education);
		return "eduDetail";
	}
	
	
	@PostMapping("/user/updateedu")
	public RedirectView updateEdu(@ModelAttribute Education education, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		education.setUserID(user.getId());
		educationService.save(education);
		return new RedirectView("/user/edu");
	}
	
	
	@GetMapping("/user/deleteedu")
	public RedirectView deleteEdu (int id) {
		educationService.deleteById(id);
		return new RedirectView("/user/edu");
	}
	
	
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}






















