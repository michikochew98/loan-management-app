package com.michiko.lendingengine.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michiko.lendingengine.domain.exception.UserNotFoundException;
import com.michiko.lendingengine.domain.model.Money;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.UserRepository;

@Component
public class BalanceService {

	private final UserRepository userRepository;
	
	@Autowired
	public BalanceService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void topUpBalance(final Money money, String authToken) {
		User user = findUser(authToken);
		user.topUp(money);
	}
	
	@Transactional
	public void withdrawFromBalance(final Money money, String authToken) {
		User user = findUser(authToken);
		user.withdraw(money);
	}
	
	private User findUser(String authToken) {
		return userRepository.findById(authToken)
				.orElseThrow(() -> new UserNotFoundException(authToken));
	}
}
