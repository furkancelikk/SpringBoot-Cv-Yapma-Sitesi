package com.furkancelik.deneme.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.furkancelik.deneme.model.Personal;
import com.furkancelik.deneme.service.PersonalService;
import com.furkancelik.deneme.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService userservice;
	
	@Autowired
	PersonalService personalService;

	@GetMapping({"/home",""})
	public ModelAndView home(Principal principal, Model model) {
		
		com.furkancelik.deneme.model.User user = userservice.findByMail(principal.getName());
		Personal personal = personalService.findByUserId(user.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("personal", personal);
		return new ModelAndView("home");
	}
}
