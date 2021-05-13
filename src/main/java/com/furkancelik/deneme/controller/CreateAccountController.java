package com.furkancelik.deneme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.UserService;

@Controller
@RequestMapping("/create")
public class CreateAccountController {

	@Autowired
	UserService userService;
	
	@GetMapping("/createaccount")
	public String createAccount(Model model) {
		model.addAttribute("user", new User());
		return "createaccount";
	}
	
	@PostMapping("/createNew")
	public ModelAndView createAccount(@ModelAttribute User user) {
		user.setRole("USER");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.createUser(user);
		return new ModelAndView("/register_success");
	}
}
