package com.michiko.profile;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michiko.profile.domain.model.User;
import com.michiko.profile.domain.repository.UserRepository;

@SpringBootApplication
public class ProfileApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("John", "John", "Wicks", 32, "Solution Architect", LocalDate.now()));
		
	}

}
