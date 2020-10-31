package com.ionix.test.service;

import java.util.List;

import com.ionix.test.exception.RESTException;
import com.ionix.test.model.User;

public interface UserService {
	public User saveUser(User user) throws RESTException;
	public User findUserByEmail(String email) throws RESTException;
	public List<User> findAllUsers();
}
