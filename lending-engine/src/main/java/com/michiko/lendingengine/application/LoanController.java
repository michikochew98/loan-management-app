package com.michiko.lendingengine.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.lendingengine.application.model.LoanRequest;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.LoanRequestRepository;
import com.michiko.lendingengine.domain.repository.UserRepository;

@RestController
public class LoanController {
	
	private final LoanRequestRepository loanRequestRepository;
	private final UserRepository userRepository;
	
	// constructor injection
	@Autowired
	public LoanController(LoanRequestRepository loanRequestRepository, UserRepository userRepository) {
		this.loanRequestRepository = loanRequestRepository;
		this.userRepository = userRepository;
	}
	
	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest) {
		System.out.println(loanRequest);
	}
	
	@GetMapping(value = "/users")
	public List<User> findUsers() {
		return userRepository.findAll();
	}
}
