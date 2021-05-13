package com.furkancelik.deneme.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.UserRepository;
import com.furkancelik.deneme.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public Collection<User> findAll()
	{
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll())
		{
			users.add(user);
		}
		return users;
	}
	
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}
	
	public User findById(int id) {
		return userRepository.findById(id).get();
	}
	
}
