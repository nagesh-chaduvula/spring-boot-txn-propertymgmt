package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entities.User;
import com.springboot.projection.UserInfo;

public interface IUserService {
	
	Long createUser(User user);
	
	List<Long> createUsers(List<User> users);
	
	User getUserById(Long id);
	
	UserInfo getUserPartialInfoById(Long id);
	
	List<User> getUsers();
	
	void updateUser(User user);
	
	String deleteUser(Long id);
	
	void deleteAllUsers();
}
