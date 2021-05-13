package com.furkancelik.deneme.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.HobiRepository;
import com.furkancelik.deneme.model.Hobi;

@Service
public class HobiService {

	@Autowired
	HobiRepository hobiRepository;
	
	public Collection<Hobi> findAllByUserID(int id){
		return hobiRepository.findAllByUserID(id);
	}
	
	public Hobi findById(int id) {
		return hobiRepository.findById(id).get();
	}
	
	public void save(Hobi hobi) {
		hobiRepository.save(hobi);
	}
	
	public void deleteById(int id) {
		hobiRepository.deleteById(id);
	}
}
