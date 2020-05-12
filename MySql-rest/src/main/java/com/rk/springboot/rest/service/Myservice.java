package com.rk.springboot.rest.service;



import java.util.List;
import java.util.Optional;

import com.rk.springboot.rest.model.User;

public interface Myservice {

	public List<User> getUsers();
	public Optional<User> getUserById(int empid);
	public User addNewUser(User user);
	public User updateUser(User user);
	public void deleteUserById(int userid);
	public void deleteAllUsers();

}