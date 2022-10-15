package com.michiko.lendingengine.application.model;

import java.util.Objects;

public class LoanRequest {

	private final int amount;
	private final int daysToRepay;
	private final double interestRate;
	
	public LoanRequest(int amount, int daysToRepay, double interestRate) {
		super();
		this.amount = amount;
		this.daysToRepay = daysToRepay;
		this.interestRate = interestRate;
	}

	public int getAmount() {
		return amount;
	}

	public int getDaysToRepay() {
		return daysToRepay;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, daysToRepay, interestRate);
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
		return amount == other.amount && daysToRepay == other.daysToRepay
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate);
	}

	@Override
	public String toString() {
		return "LoanRequest [amount=" + amount + ", daysToRepay=" + daysToRepay
				+ ", interestRate=" + interestRate + "]";
	}
	
	
	
}
