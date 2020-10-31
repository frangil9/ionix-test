package com.ionix.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.test.exception.ErrorMessage;
import com.ionix.test.exception.RESTException;
import com.ionix.test.model.User;
import com.ionix.test.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User userPersist = null;
		try {
			userPersist = this.userService.saveUser(user);
		} catch (RESTException ex) {
			return new ResponseEntity(new ErrorMessage(ex.getStatus().value(), ex.getMessage()), ex.getStatus());
		}
		
		return new ResponseEntity<User>(userPersist, HttpStatus.CREATED); 
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers(){
		List<User> users = this.userService.findAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/users/{email}")
	public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email){
		User user = null;
		
		try {
			user = this.userService.findUserByEmail(email);
		} catch (RESTException ex) {
			return new ResponseEntity(new ErrorMessage(ex.getStatus().value(), ex.getMessage()), ex.getStatus());
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
