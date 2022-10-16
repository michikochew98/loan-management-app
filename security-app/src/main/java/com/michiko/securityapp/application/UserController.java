package com.michiko.securityapp.application;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.securityapp.user.dto.UserDTO;
import com.michiko.securityapp.user.exception.UserNotFoundException;
import com.michiko.securityapp.user.model.User;
import com.michiko.securityapp.user.repository.UserRepository;
import com.michiko.securityapp.user.service.NotificationService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// TODO: Implement using Spring Securing
	
	private final UserRepository userRepository;
	private final NotificationService notificationService;
	
	@Autowired
	public UserController(UserRepository userRepository, NotificationService notificationService) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}
	
	@PostMapping(value = "/register")
	public void register(@RequestBody UserDTO userDTO) {
		User user = new User(userDTO.getUsername(), userDTO.getPassword());
		userRepository.save(user);
		notificationService.sendMessage(userDTO);
	}

	@PostMapping(value = "/validate")
	public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
		return userRepository.findById(token)
				.orElseThrow(UserNotFoundException::new).getUsername();
	}
	
}
