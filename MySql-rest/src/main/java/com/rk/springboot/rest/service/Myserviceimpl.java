package com.rk.springboot.rest.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.springboot.rest.dao.Mydaorepository;
import com.rk.springboot.rest.model.User;

@Service
public class Myserviceimpl implements Myservice {

	@Autowired
	Mydaorepository dao;

	@Override
	public List<User> getUsers() {
		return dao.findAll();
	}
	@Override
	public Optional<User> getUserById(int userid) {
		return dao.findById(userid);
	}
	@Override
	public User addNewUser(User user) {
		return dao.save(user);
	}
	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}
	@Override
	public void deleteUserById(int userid) {
		dao.deleteById(userid);
	}
	@Override
	public void deleteAllUsers() {
		dao.deleteAll();
	}
}