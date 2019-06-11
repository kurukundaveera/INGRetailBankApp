package com.hcl.ing.retailbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retailbank.app.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
	
	public TransactionHistory findByTransactionId(Long transactionId);
	
	
	
}
