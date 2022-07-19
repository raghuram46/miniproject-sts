package com.stg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Constants;
import com.stg.entity.User;
import com.stg.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@Valid @RequestBody User user) {

		return userService.createUser(user);
	}
	
	@PostMapping(value = "/authenticate")
	public Map<String, String> generateToken(@RequestBody User user) {
		long timestamp  = System.currentTimeMillis();
		String token =  Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
				.claim("userId", user.getUserId())
				.claim("userName", user.getUserName())
				.claim("email", user.getEmail())
				.compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("JWT", token);
		return map;
	}

	@GetMapping(value = "/get/{userId}")
	public User readUserByUserId(@PathVariable int userId) {

		return userService.getUserByUserId(userId);
	}

	@GetMapping(value = "/allUsers")
	public List<User> readAllUsers() {

		return userService.getAllUsers();
	}
	
	@PutMapping(value = "/update/{userId}")
	public User update(@PathVariable int userId,@RequestBody User newUser) {

		return userService.updateUser(userId, newUser);
	}

	@PutMapping(value = "/updateName/{userId}/{userName}")
	public User updateName(@PathVariable int userId, @PathVariable String userName) {

		return userService.updateUserNameById(userId, userName);
	}

	@PutMapping(value = "/updatePassword/{userId}/{password}")
	public User updatePassword(@PathVariable int userId, @PathVariable String password) {

		return userService.updatePasswordById(userId, password);
	}

	@DeleteMapping(value = "/delete/{userId}")
	public List<User> deleteUserById(@PathVariable int userId) {

		return userService.deleteUserById(userId);
	}
}
