package com.michiko.securityapp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.securityapp.user.exception.UserNotFoundException;
import com.michiko.securityapp.user.model.User;
import com.michiko.securityapp.user.repository.UserRepository;
import com.michiko.securityapp.user.service.NotificationService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// TODO: Implement using Spring Securing
	//		 Link to profile service
	
	private final UserRepository userRepository;
	private final NotificationService notificationService;
	
	@Autowired
	public UserController(UserRepository userRepository, NotificationService notificationService) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}
	
	@PostMapping(value = "/register")
	public void register(@RequestBody User user) {
		userRepository.save(user);
		notificationService.sendMessage(user);
	}

	@PostMapping(value = "/validate")
	public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
		return userRepository.findById(token)
				.orElseThrow(UserNotFoundException::new).getUsername();
	}
	
}
