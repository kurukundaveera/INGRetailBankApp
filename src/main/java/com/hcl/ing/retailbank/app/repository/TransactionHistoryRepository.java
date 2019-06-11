package com.hcl.ing.retailbank.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retailbank.app.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
	
	
	public TransactionHistory findByTransactionId(Long transactionId);
	
	@Query(value="select * from transaction_history where from_account_no=?1",nativeQuery=true)
	public List<TransactionHistory> findAll(Long fromAccNo);
	
	 
	 
	
}
