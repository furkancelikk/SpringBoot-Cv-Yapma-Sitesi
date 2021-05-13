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

import com.furkancelik.deneme.model.Experience;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.ExperienceService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class ExperienceController {

	@Autowired
	UserService userService;
	
	@Autowired
	ExperienceService experienceService;
	
	@GetMapping("/user/experience")
	public String experience(Model model, Authentication authentication)
	{
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Collection<Experience> experience = experienceService.findAllByUserId(user.getId());
		model.addAttribute("experiences", experience);
		return "experience";
	}
	
	
	@GetMapping("/user/addexperience")
	public String addExperience(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("experience", new Experience());
		model.addAttribute("user", user);
		return "addexperience";
	}
	
	
	@PostMapping("/user/newexperience")
	public RedirectView addExperience(Authentication authentication, @ModelAttribute Experience experience)
	{
		User user = getCurrentUser(authentication);
		user.getExperience().add(experience);
		userService.createUser(user);
		return new RedirectView("/user/experience");
		
	}
	
	@GetMapping("/user/experiencedetail")
	public String experienceDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Experience experience = experienceService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("experience", experience);
		return "experienceDetail";
	}
	
	
	@PostMapping("/user/updateexperience")
	public RedirectView updateExperience(@ModelAttribute Experience experience, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		experience.setUserID(user.getId());
		experienceService.save(experience);
		return new RedirectView("/user/experience");
	}
	
	
	@GetMapping("/user/deleteexperience")
	public RedirectView deleteExperience (int id) {
		experienceService.deleteById(id);
		return new RedirectView("/user/experience");
	}
	
	
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}
