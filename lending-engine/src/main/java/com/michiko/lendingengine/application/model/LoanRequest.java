package com.michiko.lendingengine.application.model;

import java.time.Duration;
import java.util.Objects;

import com.michiko.lendingengine.domain.model.User;

public class LoanRequest {

	private final int amount;
	private final long borrowerId;
	private final int daysToRepay;
	private final double interestRate;
	
	public LoanRequest(int amount, long borrowerId, int daysToRepay, double interestRate) {
		super();
		this.amount = amount;
		this.borrowerId = borrowerId;
		this.daysToRepay = daysToRepay;
		this.interestRate = interestRate;
	}

	public int getAmount() {
		return amount;
	}

	public long getBorrowerId() {
		return borrowerId;
	}

	public int getDaysToRepay() {
		return daysToRepay;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, borrowerId, daysToRepay, interestRate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanRequest other = (LoanRequest) obj;
		return amount == other.amount && borrowerId == other.borrowerId && daysToRepay == other.daysToRepay
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate);
	}

	@Override
	public String toString() {
		return "LoanRequest [amount=" + amount + ", borrowerId=" + borrowerId + ", daysToRepay=" + daysToRepay
				+ ", interestRate=" + interestRate + "]";
	}
	
	
	
}
