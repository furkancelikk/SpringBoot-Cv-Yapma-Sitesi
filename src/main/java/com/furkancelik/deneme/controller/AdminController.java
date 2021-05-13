package com.furkancelik.deneme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.furkancelik.deneme.model.Personal;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.PersonalService;
import com.furkancelik.deneme.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonalService personalService;
	
	@GetMapping({"/home", ""})
	public ModelAndView admin(Model model) {
		
		List<User> users = (List<User>)userService.findAll();
		model.addAttribute("users", users);
		return new ModelAndView("users");
	}
	
	@GetMapping("/userdetail")
	public ModelAndView userDetail(@RequestParam int id, Model model)
	{
		User user = userService.findById(id);
		Personal personal = personalService.findByUserId(user.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("personal", personal);
		
		return new ModelAndView("userdetail");
		
	}

}







