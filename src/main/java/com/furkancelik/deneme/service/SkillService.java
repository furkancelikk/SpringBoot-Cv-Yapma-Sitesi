package com.furkancelik.deneme.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.SkillRepository;
import com.furkancelik.deneme.model.Skill;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	public Collection<Skill> findAllByUserID(int id) {
		return skillRepository.findAllByUserID(id);
	}
	
	public Skill findById(int id) {
		return skillRepository.findById(id).get();
	}
	
	public void save(Skill skill) {
		skillRepository.save(skill);
	}
	
	public void deleteById(int id) {
		skillRepository.deleteById(id);
	}
	
}
