package com.furkancelik.deneme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.Hobi;

@Repository
public interface HobiRepository extends JpaRepository<Hobi, Integer> {
	
	List<Hobi> findAllByUserID(int id);
}
