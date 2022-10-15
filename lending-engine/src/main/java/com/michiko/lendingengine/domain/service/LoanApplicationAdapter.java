package com.michiko.lendingengine.domain.service;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michiko.lendingengine.application.model.LoanRequest;
import com.michiko.lendingengine.domain.exception.UserNotFoundException;
import com.michiko.lendingengine.domain.model.LoanApplication;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.UserRepository;

@Component
public class LoanApplicationAdapter {
	
	private final UserRepository userRepository;
	
	@Autowired
	public LoanApplicationAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public LoanApplication transform(LoanRequest req, User borrower) {
		Optional<User> userOptional = userRepository.findById(borrower.getUsername());
		
		if(userOptional.isPresent()) {
			return new LoanApplication(req.getAmount(), userOptional.get(), 
					req.getDaysToRepay(), req.getInterestRate());
		} else {
			throw new UserNotFoundException(borrower.getUsername());
		}
		
	}

}
