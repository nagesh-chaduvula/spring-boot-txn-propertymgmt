package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.entities.User;
import com.springboot.projection.UserInfo;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	UserInfo findUserInfoById(Long id);

}
