package com.michiko.securityapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michiko.securityapp.user.model.User;
import com.michiko.securityapp.user.repository.UserRepository;

@SpringBootApplication
public class SecurityAppApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityAppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("John", "12345"));
		userRepository.save(new User("Jolly", "12345"));
		userRepository.save(new User("Nancy", "12345"));
		userRepository.save(new User("Jaqueline", "12345"));
	}

}
