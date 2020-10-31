package com.ionix.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ionix.test.exception.RESTException;
import com.ionix.test.model.User;
import com.ionix.test.repository.UserRepository;
import com.ionix.test.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws RESTException {
		User username = this.userRepository.findByUsername(user.getUsername()); 
		if (username != null) {
			throw new RESTException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con el username "+user.getUsername());
		}
		User email = this.userRepository.findByEmail(user.getEmail()); 
		if (email != null) {
			throw new RESTException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con el email "+user.getEmail());
		}
		User phone = this.userRepository.findByPhone(user.getPhone()); 
		if (phone != null) {
			throw new RESTException(HttpStatus.BAD_REQUEST, "Ya existe un usuario registrado con el teléfono "+user.getPhone());
		}
		User userSave = this.userRepository.save(user);
		return userSave;
	}

	@Override
	public List<User> findAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User findUserByEmail(String email) throws RESTException {
		User mail = this.userRepository.findByEmail(email); 
		if (mail == null) {
			throw new RESTException(HttpStatus.NOT_FOUND, "El usuario con email "+email+ " no existe");
		}
		return mail;
	}

}
