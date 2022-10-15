package com.michiko.lendingengine.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.michiko.lendingengine.domain.exception.UserNotFoundException;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.UserRepository;

@Component
public class TokenValidationService {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate = new RestTemplate();
	private final String securityContextBaseUrl;
	
	@Autowired
	public TokenValidationService(final UserRepository userRepository, @Value("${security.baseurl}") String securityContextBaseUrl) {
		this.userRepository = userRepository;
		this.securityContextBaseUrl = securityContextBaseUrl;
	}
	
	public User validateTokenAndGetUser(final String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
		HttpEntity httpEntity = new HttpEntity(httpHeaders);
		
		ResponseEntity<String> response = restTemplate
				.exchange(securityContextBaseUrl + "/user/validate", HttpMethod.POST, httpEntity, String.class);
		
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			return userRepository.findById(response.getBody())
					.orElseThrow(() -> new UserNotFoundException(response.getBody()));
		}
		
		throw new RuntimeException("Invalid token");
		
	}
}
