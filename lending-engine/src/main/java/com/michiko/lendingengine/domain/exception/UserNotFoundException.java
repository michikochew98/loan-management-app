package com.michiko.lendingengine.domain.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String username) {
		super("User with id: " + username + " was not found");
	}
}
