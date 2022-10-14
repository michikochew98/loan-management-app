package com.michiko.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.lendingengine.domain.model.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{

}
