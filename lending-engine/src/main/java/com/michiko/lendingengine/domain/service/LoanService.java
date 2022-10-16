package com.michiko.lendingengine.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michiko.lendingengine.domain.exception.LoanApplicationNotFoundException;
import com.michiko.lendingengine.domain.exception.LoanNotFoundException;
import com.michiko.lendingengine.domain.exception.UserNotFoundException;
import com.michiko.lendingengine.domain.model.Currency;
import com.michiko.lendingengine.domain.model.Loan;
import com.michiko.lendingengine.domain.model.LoanApplication;
import com.michiko.lendingengine.domain.model.Money;
import com.michiko.lendingengine.domain.model.Status;
import com.michiko.lendingengine.domain.model.User;
import com.michiko.lendingengine.domain.repository.LoanApplicationRepository;
import com.michiko.lendingengine.domain.repository.LoanRepository;
import com.michiko.lendingengine.domain.repository.UserRepository;

@Component
public class LoanService {

	private final LoanApplicationRepository loanApplicationRepository;
	private final UserRepository userRepository;
	private final LoanRepository loanRepository;
	
	@Autowired
	public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository,
			LoanRepository loanRepository) {
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanRepository = loanRepository;
	}
	
	@Transactional
	public void repayLoan(final Money amountToRepay,
			final long loanId, final User borrower) {
		Loan loan = loanRepository.findOneByIdAndBorrower(loanId, borrower)
				.orElseThrow(() -> new LoanNotFoundException());
		
		Money actualPaidAmountMoney = amountToRepay.getAmount() > loan.getAmountOwed().getAmount() ?
				loan.getAmountOwed() : amountToRepay;
		
		loan.repay(actualPaidAmountMoney);
	}

	@Transactional
	public void acceptLoan(final long loanApplicationId, final String lenderUsername) {
		User lender = findUser(lenderUsername);
		LoanApplication loanApplication = findLoanApplication(loanApplicationId);
		loanRepository.save(loanApplication.acceptLoanApplication(lender));
	}
	
	public List<Loan> findAllBorrowedLoans(final User user, final Status status) {
		return loanRepository.findAllByBorrowerAndStatus(user, status);
	}
	
	public List<Loan> findAllLentLoans(final User user, final Status status) {
		return loanRepository.findAllByLenderAndStatus(user, status);
	}
	
	public List<Loan> getLoans() {
		return loanRepository.findAll();
	}
	
	private User findUser(String lenderUsername) {
		return userRepository.findById(lenderUsername).orElseThrow(() -> new UserNotFoundException(lenderUsername));
	}
	
	private LoanApplication findLoanApplication(final long loanApplicationId) {
		return loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId));
	}
}
