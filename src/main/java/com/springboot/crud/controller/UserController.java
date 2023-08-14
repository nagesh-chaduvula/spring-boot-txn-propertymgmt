package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entities.User;
import com.springboot.crud.service.IUserService;
import com.springboot.projection.UserInfo;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/addUser")
	public Long addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<Long> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/userPartialInfo/{id}")
	public UserInfo getUserPartialInfoById(@PathVariable Long id) {
		return userService.getUserPartialInfoById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/updateUser")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
	@DeleteMapping("users")
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}
	
}
