package com.furkancelik.deneme.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.furkancelik.deneme.model.User;
import com.furkancelik.deneme.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public RedirectView redirect(Principal principal, Model model)
	{
		if(principal==null)
			return new RedirectView("login");
		
		User user = userService.findByMail(principal.getName());

		
		if(user.getRole().equals("USER"))
		{
			return new RedirectView("user/home");
		}
		return new RedirectView("admin/home");
	}
}
