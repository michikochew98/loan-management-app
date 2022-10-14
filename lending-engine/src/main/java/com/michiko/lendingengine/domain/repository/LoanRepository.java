package com.michiko.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.lendingengine.domain.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
