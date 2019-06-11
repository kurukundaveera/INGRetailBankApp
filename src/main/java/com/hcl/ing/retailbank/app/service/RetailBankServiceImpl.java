package com.hcl.ing.retailbank.app.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retailbank.app.entity.AccountSummary;
import com.hcl.ing.retailbank.app.repository.AccountSummaryRepository;

@Service
public class RetailBankServiceImpl implements RetailBankService {

	private static final Logger logger = LogManager.getLogger(RetailBankServiceImpl.class);

	//account summary details for a given account number
	//author ismail
	
	@Autowired
	AccountSummaryRepository accountSummaryRepository;

	@Override
	public ResponseEntity<AccountSummaryResponse> accountSummary(Long acccountNumber) {
		AccountSummaryResponse accountSummaryResponse = new AccountSummaryResponse();

		try {
			//hitting the database and getting details from repository
			
			Optional<AccountSummary> accountSummaryOp = accountSummaryRepository.findById(11L);
			AccountSummary accountSummary = accountSummaryOp.get();
			accountSummaryResponse.setAccountType(accountSummary.getAccountType());
			accountSummaryResponse.setClosingBalance(accountSummary.getClosingBalance());
			accountSummaryResponse.setCreateDt(accountSummary.getCreateDt());
			accountSummaryResponse.setAccountNo(accountSummary.getAccountNo());
			accountSummaryResponse.setMeassage("please find account details");
			return ResponseEntity.status(200).body(accountSummaryResponse);
		} catch (Exception e) {
			logger.error(e.getMessage());
			accountSummaryResponse.setMeassage("sorry something went wrong with accountSummary Details");
			return ResponseEntity.status(500).body(accountSummaryResponse);

		}

	}

}
