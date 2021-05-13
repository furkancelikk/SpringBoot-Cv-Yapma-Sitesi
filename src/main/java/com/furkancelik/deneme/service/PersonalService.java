package com.furkancelik.deneme.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.PersonalRepository;
import com.furkancelik.deneme.model.Personal;

@Service
public class PersonalService {

	@Autowired
	PersonalRepository personalRepository;
	
	public Personal findByUserId(int id) {
		return personalRepository.findByUserID(id);
	}
	
	public Personal findById(int id) {
		return personalRepository.findById(id).get();
	}
	
	public void save(Personal personal) {
		personalRepository.save(personal);
	}
	
	public void deleteById(int id) {
		personalRepository.deleteById(id);
	}
}


