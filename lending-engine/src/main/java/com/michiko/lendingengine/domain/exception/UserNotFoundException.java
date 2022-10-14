package com.michiko.lendingengine.domain.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(long userId) {
		super("User with id: " + userId + " was not found");
	}
}
