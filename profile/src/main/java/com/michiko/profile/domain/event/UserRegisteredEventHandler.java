package com.michiko.profile.domain.event;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.michiko.profile.domain.model.User;
import com.michiko.profile.domain.repository.UserRepository;


@Component
public class UserRegisteredEventHandler {
	
	private Logger LOGGER = LoggerFactory.getLogger(UserRegisteredEventHandler.class);
	private static final Gson GSON = new Gson();
	private final UserRepository userRepository;
	
	@Autowired
	public UserRegisteredEventHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void handleUserRegistration(String userDetails) {
		// TODO: deserialize local date field by building type adapter as GSON 
		User user = GSON.fromJson(userDetails, User.class);
		user.setRegisteredSince(LocalDate.now());
		LOGGER.info("user {} registered", user.getRegisteredSince());
		userRepository.save(user);
	}
}
