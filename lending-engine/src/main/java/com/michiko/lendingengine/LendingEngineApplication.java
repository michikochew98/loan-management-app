package com.michiko.lendingengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.UserRepository;

@SpringBootApplication
public class LendingEngineApplication implements CommandLineRunner {

	// field injection
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LendingEngineApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1, "John", "Wicks", 32, "Solution Architect"));
		userRepository.save(new User(2, "May", "Niana", 24, "Software Developer"));
		userRepository.save(new User(3, "Nancy", "Woo", 21, "IT student"));
		userRepository.save(new User(4, "Jaqueline", "Paula", 45, "System Analyst"));
	}
 
}
