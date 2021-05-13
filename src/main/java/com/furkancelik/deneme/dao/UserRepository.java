package com.furkancelik.deneme.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancelik.deneme.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByMail(String name);
}
