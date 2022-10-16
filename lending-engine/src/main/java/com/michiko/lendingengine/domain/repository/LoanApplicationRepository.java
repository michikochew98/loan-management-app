package com.michiko.lendingengine.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.lendingengine.domain.model.LoanApplication;
import com.michiko.lendingengine.domain.model.Status;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{

	List<LoanApplication> findAllByStatusEquals(Status status);
}
