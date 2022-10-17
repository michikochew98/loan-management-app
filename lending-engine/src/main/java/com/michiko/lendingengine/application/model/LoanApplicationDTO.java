package com.michiko.lendingengine.application.model;

import java.util.Objects;

import com.michiko.lendingengine.domain.exception.UserNotFoundException;
import com.michiko.lendingengine.domain.model.Money;
import com.michiko.lendingengine.domain.model.User;

public class LoanApplicationDTO {

	private long id;
	private Money amount;
	private User borrower;
	private int repaymentTermInDays;
	private double interestRate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public int getRepaymentTermInDays() {
		return repaymentTermInDays;
	}

	public void setRepaymentTermInDays(int repaymentTermInDays) {
		this.repaymentTermInDays = repaymentTermInDays;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, interestRate, repaymentTermInDays, borrower);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LoanApplicationDTO))
			return false;
		LoanApplicationDTO other = (LoanApplicationDTO) obj;
		return Objects.equals(amount, other.amount) && id == other.id
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate)
				&& repaymentTermInDays == other.repaymentTermInDays && Objects.equals(borrower, other.borrower);
	}
	
	@Override
	public String toString() {
		return "LoanApplicationDTO [id=" + id + ", amount=" + amount + ", borrower=" + borrower + ", repaymentTermInDays="
				+ repaymentTermInDays + ", interestRate=" + interestRate + "]";
	}
	
	
}
