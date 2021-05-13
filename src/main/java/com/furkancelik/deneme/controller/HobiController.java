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

import com.furkancelik.deneme.model.Hobi;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.HobiService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class HobiController {

	@Autowired
	UserService userService;
	
	@Autowired
	HobiService hobiService;
	
	@GetMapping("/user/hobi")
	public String hobi(Model model, Authentication authentication)
	{
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Collection<Hobi> hobbies = hobiService.findAllByUserID(user.getId());
		model.addAttribute("hobbies", hobbies);
		return "hobi";
	}
	
	
	@GetMapping("/user/addhobi")
	public String addHobi(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("hobi", new Hobi());
		model.addAttribute("user", user);
		return "addhobi";
	}
	
	
	@PostMapping("/user/newhobi")
	public RedirectView addHobi(Authentication authentication, @ModelAttribute Hobi hobi)
	{
		User user = getCurrentUser(authentication);
		user.getHobbies().add(hobi);
		userService.createUser(user);
		return new RedirectView("/user/hobi");
		
	}
	
	@GetMapping("/user/hobidetail")
	public String hobiDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Hobi hobi = hobiService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("hobi", hobi);
		return "hobiDetail";
	}
	
	
	@PostMapping("/user/updatehobi")
	public RedirectView updateHobi(@ModelAttribute Hobi hobi, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		hobi.setUserID(user.getId());
		hobiService.save(hobi);
		return new RedirectView("/user/hobi");
	}
	
	
	@GetMapping("/user/deletehobi")
	public RedirectView deleteHobi (int id) {
		hobiService.deleteById(id);
		return new RedirectView("/user/hobi");
	}
	
	
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}
