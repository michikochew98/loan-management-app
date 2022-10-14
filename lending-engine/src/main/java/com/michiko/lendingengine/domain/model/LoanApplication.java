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
	
	public LoanApplication() {
		
	}
	
	public LoanApplication(int amount, User borrower, int repaymentTermInDays, double interestRate) {
		this.amount = amount;
		this.borrower = borrower;
		this.repaymentTermInDays = repaymentTermInDays;
		this.interestRate = interestRate;
	}	

	public long getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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
