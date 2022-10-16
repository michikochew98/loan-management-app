package com.michiko.lendingengine.domain.model;

import java.time.Duration;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LoanApplication {

	@Id
	@GeneratedValue
	private long id;
	private int amount;
	@ManyToOne
	private User borrower;
	private int repaymentTermInDays;
	private double interestRate;
	private Status status;
	
	public LoanApplication() {
		
	}
	
	public LoanApplication(int amount, User borrower, int repaymentTermInDays, double interestRate) {
		this.amount = amount;
		this.borrower = borrower;
		this.repaymentTermInDays = repaymentTermInDays;
		this.interestRate = interestRate;
		this.status = Status.ONGOING;
	}	
	
	public Loan acceptLoanApplication(final User lender) {
		lender.withdraw(getAmount());
		borrower.topUp(getAmount());
		status = Status.COMPLETED;
		return new Loan(lender, this);
	}

	public long getId() {
		return id;
	}

	public Money getAmount() {
		return new Money(Currency.USD, amount);
	}

	public User getBorrower() {
		return borrower;
	}

	public int getRepaymentTermInDays() {
		return repaymentTermInDays;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, borrower, id, interestRate, repaymentTermInDays);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApplication other = (LoanApplication) obj;
		return amount == other.amount && Objects.equals(borrower, other.borrower) && id == other.id
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate)
				&& repaymentTermInDays == other.repaymentTermInDays;
	}

	@Override
	public String toString() {
		return "LoanApplication [id=" + id + ", amount=" + amount + ", borrower=" + borrower + ", repaymentTermInDays="
				+ repaymentTermInDays + ", interestRate=" + interestRate + "]";
	}
	
	
	
}
