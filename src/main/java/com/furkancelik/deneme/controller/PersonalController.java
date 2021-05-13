package com.furkancelik.deneme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.furkancelik.deneme.model.Personal;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.PersonalService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class PersonalController {

	@Autowired
	UserService userService;
	
	@Autowired
	PersonalService personalService;
	
	@GetMapping("/user/personal")
	public String personal(Model model, Authentication authentication)
	{
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Personal personals = personalService.findByUserId(user.getId());
		model.addAttribute("personals", personals);
		return "personal";
	}
	
	
	@GetMapping("/user/addpersonal")
	public String addPersonal(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("personal", new Personal());
		model.addAttribute("user", user);
		return "addpersonal";
	}
	
	
	@PostMapping("/user/newpersonal")
	public RedirectView addPersonal(Authentication authentication, @ModelAttribute Personal personal)
	{
		User user = getCurrentUser(authentication);
		personal.setUserID(user.getId());
		personalService.save(personal);
		return new RedirectView("/user/personal");
		
	}
	
	@GetMapping("/user/personaldetail")
	public String personalDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Personal personal = personalService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("personal", personal);
		return "personalDetail";
	}
	
	
	@PostMapping("/user/updatepersonal")
	public RedirectView updatePersonal(@ModelAttribute Personal personal, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		personal.setUserID(user.getId());
		personalService.save(personal);
		return new RedirectView("/user/personal");
	}
	
	
	@GetMapping("/user/deletepersonal")
	public RedirectView deletePersonal (int id) {
		personalService.deleteById(id);
		return new RedirectView("/user/personal");
	}
	
	
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}
