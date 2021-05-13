package com.furkancelik.deneme.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.ExperienceRepository;
import com.furkancelik.deneme.model.Experience;

@Service
public class ExperienceService {

	@Autowired
	ExperienceRepository experienceRepository;
	
	public Collection<Experience> findAllByUserId(int id){
		return experienceRepository.findAllByUserID(id);
	}
	
	public Experience findById(int id) {
		return experienceRepository.findById(id).get();
	}
	
	public void save(Experience experience) {
		experienceRepository.save(experience);
	}
	
	public void deleteById(int id) {
		experienceRepository.deleteById(id);
	}
}
