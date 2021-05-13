package com.furkancelik.deneme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkancelik.deneme.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer>{

	List<Education> findAllByUserID(int id);
}
