package com.furkancelik.deneme.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancelik.deneme.dao.ReferencesRepository;
import com.furkancelik.deneme.model.Reference;

@Service
public class ReferenceService {

	@Autowired
	ReferencesRepository referencesRepository;
	
	public Collection<Reference> findAllByUserID(int id) {
		return referencesRepository.findAllByUserID(id);
	}
	
	public Reference findById(int id) {
		return referencesRepository.findById(id).get();
	}
	
	public void save(Reference reference) {
		referencesRepository.save(reference);
	}
	
	public void deleteById(int id) {
		referencesRepository.deleteById(id);
	}
}
