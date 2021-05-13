package com.furkancelik.deneme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.Reference;


@Repository
public interface ReferencesRepository extends JpaRepository<Reference, Integer> {

	List<Reference> findAllByUserID(int id);
}
