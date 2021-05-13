package com.furkancelik.deneme.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.EducationRepository;
import com.furkancelik.deneme.model.Education;

@Service
public class EducationService {

	@Autowired
	EducationRepository educationRepository;
	
	public Collection<Education> findAllByUserId(int id){
		return educationRepository.findAllByUserID(id);
	}
	
	public Education findById(int id) {
		return educationRepository.findById(id).get();
	}
	
	public void save(Education education) {
		educationRepository.save(education);
	}
	
	public void deleteById(int id) {
		educationRepository.deleteById(id);
	}
}
