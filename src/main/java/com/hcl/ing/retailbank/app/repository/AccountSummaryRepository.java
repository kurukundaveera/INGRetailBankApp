package com.hcl.ing.retailbank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retailbank.app.entity.AccountSummary;

@Repository
public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Long> {
	
	public AccountSummary findByAccountNo(Long accountNo);
	
	
	

}
