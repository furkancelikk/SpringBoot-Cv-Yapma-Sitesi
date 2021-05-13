package com.furkancelik.deneme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{

	List<Skill> findAllByUserID(int id);
}
