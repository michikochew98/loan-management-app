package com.michiko.lendingengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michiko.lendingengine.domain.model.Balance;
import com.michiko.lendingengine.domain.model.Currency;
import com.michiko.lendingengine.domain.model.Money;
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
		User johnUser = userRepository.save(new User("John", "John", "Wicks", 32, "Solution Architect", new Balance()));
		User jollyUser = userRepository.save(new User("Jolly", "Jolly", "Niana", 24, "Software Developer", new Balance()));
		johnUser.topUp(new Money(Currency.USD, 100));
		jollyUser.topUp(new Money(Currency.USD, 100));
		userRepository.save(johnUser);
		userRepository.save(jollyUser);
		userRepository.save(new User("Nancy", "Nancy", "Woo", 21, "IT student", new Balance()));
		userRepository.save(new User("Jaqueline", "Jaqueline", "Paula", 45, "System Analyst", new Balance()));
	}
 
}
