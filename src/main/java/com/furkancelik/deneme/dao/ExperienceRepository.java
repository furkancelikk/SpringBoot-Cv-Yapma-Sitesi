package com.furkancelik.deneme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

	List<Experience> findAllByUserID(int id);
}
