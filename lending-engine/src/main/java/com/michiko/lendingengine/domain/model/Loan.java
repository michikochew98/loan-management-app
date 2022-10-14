package com.michiko.lendingengine.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private User borrower;
	@ManyToOne
	private User lender;
	private int amount;
	private double interestRate;
	private LocalDate dateLent;
	private LocalDate dateDue;
	
	public Loan() {
		
	}
	
	public Loan(User lender, LoanApplication loanApplication) {
		this.borrower = loanApplication.getBorrower();
		this.lender = lender;
		this.amount = loanApplication.getAmount();
		this.interestRate = loanApplication.getInterestRate();
		this.dateLent = LocalDate.now();
		this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public User getLender() {
		return lender;
	}

	public void setLender(User lender) {
		this.lender = lender;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getDateLent() {
		return dateLent;
	}

	public void setDateLent(LocalDate dateLent) {
		this.dateLent = dateLent;
	}

	public LocalDate getDateDue() {
		return dateDue;
	}

	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}
	
	
	
}
