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

import com.furkancelik.deneme.model.Reference;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.ReferenceService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class ReferenceController {

	@Autowired
	UserService userService;
	
	@Autowired
	ReferenceService referencesService;
	
	@GetMapping("/user/reference")
	public String references(Model model, Authentication authentication)
	{
		
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Collection<Reference> references = referencesService.findAllByUserID(user.getId());
		model.addAttribute("references", references);
		
		
		return "reference";
	}
	
	@GetMapping("/user/addreference")
	public String addReferences(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("reference", new Reference());
		model.addAttribute("user", user);
		return "addreference";
	}
	
	@PostMapping("/user/newreference")
	public RedirectView addReferences(Authentication authentication, @ModelAttribute Reference reference)
	{
		User user = getCurrentUser(authentication);
		user.getReferences().add(reference);
		userService.createUser(user);
		return new RedirectView("/user/reference");
		
	}
	
	
	@GetMapping("/user/referencedetail")
	public String referencesDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Reference reference = referencesService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("reference", reference);
		return "referenceDetail";
	}
	
	
	@PostMapping("/user/updatereference")
	public RedirectView updateReferences(@ModelAttribute Reference reference, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		reference.setUserID(user.getId());
		referencesService.save(reference);
		return new RedirectView("/user/reference");
	}
	
	
	@GetMapping("/user/deletereference")
	public RedirectView deleteReferences (int id) {
		referencesService.deleteById(id);
		return new RedirectView("/user/reference");
	}
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}




















