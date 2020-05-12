package com.rk.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.rk.springboot.rest.model.User;
 
@Repository
public interface Mydaorepository extends JpaRepository<User, Integer> {
 
}
