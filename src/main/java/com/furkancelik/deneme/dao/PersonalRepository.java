package com.furkancelik.deneme.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

	Personal findByUserID(int id);
}
