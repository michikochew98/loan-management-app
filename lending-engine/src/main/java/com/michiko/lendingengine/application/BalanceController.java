package com.michiko.lendingengine.application;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michiko.lendingengine.domain.model.Money;
import com.michiko.lendingengine.domain.service.BalanceService;

@RestController
@RequestMapping("/balance")
public class BalanceController {

	private final BalanceService balanceService;
	
	public BalanceController(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	
	@PostMapping("/topup")
	public void topUp(@RequestBody final Money money, 
			@RequestHeader String authorization) {
		balanceService.topUpBalance(money, authorization);
	}
	
	@PostMapping("/withdraw")
	public void withdraw(@RequestBody final Money money, 
			@RequestHeader String authorization) {
		balanceService.withdrawFromBalance(money, authorization);
	}
	
}
