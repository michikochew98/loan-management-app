package com.michiko.lendingengine.application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.lendingengine.application.service.TokenValidationService;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.LoanApplicationRepository;
import com.michiko.lendingengine.domain.repository.UserRepository;
import com.michiko.lendingengine.domain.service.LoanApplicationAdapter;
import com.michiko.lendingengine.domain.service.LoanService;

@RestController
public class UserController {
	
	private final UserRepository userRepository;
	private final TokenValidationService tokenValidationService;
	
	@Autowired
	public UserController(UserRepository userRepository,
			TokenValidationService tokenValidationService) {
		this.userRepository = userRepository;
		this.tokenValidationService = tokenValidationService;
	}

	@GetMapping(value = "/users")
	public List<User> findUsers(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return userRepository.findAll();
	}
}
