package com.furkancelik.deneme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.furkancelik.deneme.dao.UserRepository;


@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	
}
