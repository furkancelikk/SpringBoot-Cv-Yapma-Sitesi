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

import com.furkancelik.deneme.model.Skill;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.SkillService;
import com.furkancelik.deneme.service.UserService;

@Controller
public class SkillController {

	@Autowired
	UserService userService;
	
	@Autowired
	SkillService skillService;
	
	@GetMapping("/user/skill")
	public String skill(Model model, Authentication authentication)
	{
		User user =  getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		Collection<Skill> skills = skillService.findAllByUserID(user.getId());
		model.addAttribute("skills", skills);
		return "skill";
	}
	
	
	@GetMapping("/user/addskill")
	public String addSkill(Model model, Authentication authentication)
	{
		User user = getCurrentUser(authentication);
		model.addAttribute("skill", new Skill());
		model.addAttribute("user", user);
		return "addskill";
	}
	
	
	@PostMapping("/user/newskill")
	public RedirectView addSkill(Authentication authentication, @ModelAttribute Skill skill)
	{
		User user = getCurrentUser(authentication);
		user.getSkills().add(skill);
		userService.createUser(user);
		return new RedirectView("/user/skill");
		
	}
	
	@GetMapping("/user/skilldetail")
	public String skillDetail(@RequestParam int id, Model model, Authentication authentication) {
		
		Skill skill = skillService.findById(id);
		
		User user = getCurrentUser(authentication);
		
		model.addAttribute("user", user);
		model.addAttribute("skill", skill);
		return "skillDetail";
	}
	
	
	@PostMapping("/user/updateskill")
	public RedirectView updateSkill(@ModelAttribute Skill skill, Authentication authentication) {
		
		User user = getCurrentUser(authentication);
		
		skill.setUserID(user.getId());
		skillService.save(skill);
		return new RedirectView("/user/skill");
	}
	
	
	@GetMapping("/user/deleteskill")
	public RedirectView deleteSkill (int id) {
		skillService.deleteById(id);
		return new RedirectView("/user/skill");
	}
	
	
	
	
	
	public User getCurrentUser(Authentication authentication) {
		return userService.findByMail(authentication.getName());
	}
}
