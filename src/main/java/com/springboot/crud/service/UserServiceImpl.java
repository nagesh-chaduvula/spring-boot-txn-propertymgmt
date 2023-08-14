package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.entities.User;
import com.springboot.crud.repository.UserRepository;
import com.springboot.projection.UserInfo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Long createUser(User user) {
		return userRepository.save(user).getId();
	}

	@Override
	public List<Long> createUsers(List<User> users) {
		List<User> createdUsers = userRepository.saveAll(users);
		return createdUsers.stream().map(User::getId).collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public UserInfo getUserPartialInfoById(Long id) {
		return userRepository.findUserInfoById(id);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void updateUser(User user) {

		Thread t1 = new Thread(() -> {
			User existingUser = null;
			Optional<User> optionalUser = userRepository.findById(user.getId());
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (optionalUser.isPresent()) {
				existingUser = optionalUser.get();
				existingUser.setName(user.getName());
				existingUser.setEmail(user.getEmail());
				existingUser.setMobile(user.getMobile());
				existingUser.setAddress(user.getAddress());
				userRepository.save(existingUser);
			}
		});

		Thread t2 = new Thread(() -> {
			User existingUser = null;
			Optional<User> optionalUser = userRepository.findById(user.getId());
			if (optionalUser.isPresent()) {
				existingUser = optionalUser.get();
				existingUser.setName(user.getName());
				existingUser.setEmail(user.getEmail());
				existingUser.setMobile(user.getMobile());
				existingUser.setAddress(user.getAddress());
				userRepository.save(existingUser);
			}
		});

		t1.start();
		t2.start();
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "User id: " + id + " deleted successfully...";
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

}
