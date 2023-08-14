package com.springboot;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}
	
	@Bean
	DefaultLockRepository defaultLockRepository(DataSource dataSource) {
		return new DefaultLockRepository(dataSource);
	}
	
	@Bean
	JdbcLockRegistry jdbcLockRegistry(LockRepository lockRepository) {
		return new JdbcLockRegistry(lockRepository);
	}

}
