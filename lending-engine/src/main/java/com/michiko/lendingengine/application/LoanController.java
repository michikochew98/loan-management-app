package com.michiko.lendingengine.application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.lendingengine.application.model.LoanRequest;
import com.michiko.lendingengine.application.service.TokenValidationService;
import com.michiko.lendingengine.domain.model.Loan;
import com.michiko.lendingengine.domain.model.LoanApplication;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.LoanApplicationRepository;
import com.michiko.lendingengine.domain.repository.UserRepository;
import com.michiko.lendingengine.domain.service.LoanApplicationAdapter;
import com.michiko.lendingengine.domain.service.LoanService;

@RestController
public class LoanController {
	
	// TODO: make hour payment term
	
	private final LoanApplicationRepository loanApplicationRepository;
	private final UserRepository userRepository;
	private final LoanApplicationAdapter loanApplicationAdapter;
	private final LoanService loanService;
	private final TokenValidationService tokenValidationService;
	
	// constructor injection
	@Autowired
	public LoanController(LoanApplicationRepository loanApplicationRepository, 
			UserRepository userRepository,
			LoanApplicationAdapter loanApplicationAdapter,
			LoanService loanService, TokenValidationService tokenValidationService) {
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanApplicationAdapter = loanApplicationAdapter;
		this.loanService = loanService;
		this.tokenValidationService = tokenValidationService;
	}
	
	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest, HttpServletRequest request) {
		User borrowerUser = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest, borrowerUser));
	}
	
	@GetMapping(value = "/loan/requests")
	public List<LoanApplication> findAllLoanApplications(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return loanApplicationRepository.findAll();
	}
	
	@GetMapping(value = "/users")
	public List<User> findUsers(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/loan/accept/{loanApplicationId}")
	public void acceptLoan(@PathVariable final String loanApplicationId, HttpServletRequest request) {
		User lender = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		loanService.acceptLoan(Long.parseLong(loanApplicationId), lender.getUsername());
	}
	
	@GetMapping(value = "/loans")
	public List<Loan> getLoans() {
		return loanService.getLoans();	
	}
	
}
