package com.michiko.lendingengine.application.service;

import com.michiko.lendingengine.domain.model.User;

public interface TokenValidationService {

	User validateTokenAndGetUser(final String token);
}
