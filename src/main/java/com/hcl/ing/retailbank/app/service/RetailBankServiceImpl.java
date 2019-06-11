package com.hcl.ing.retailbank.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retailbank.app.dto.TransactionResponse;
import com.hcl.ing.retailbank.app.entity.TransactionHistory;
import com.hcl.ing.retailbank.app.repository.TransactionHistoryRepository;

@Service
public class RetailBankServiceImpl implements RetailBankService {
	
	private static final Logger logger=LogManager.getLogger(RetailBankServiceImpl.class);
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	public TransactionResponse viewLastTenTransactionDetails(Long accountNumber) {
		logger.info("Entering into viewLastTenTransactionDetails() in TransactionHistoryRepository...");
		TransactionResponse response=new TransactionResponse();
		List<TransactionHistory> list=null;
		try {
			
			list=transactionHistoryRepository.findAll(accountNumber);
			if(list!=null && !list.isEmpty()) {
			response.setMessage("SUCCESS");
			response.setStatusCode(200);
			response.setList(list);
		}
		else {
			response.setMessage("FAILURE: Account number "+accountNumber+" Not Found");
			response.setStatusCode(404);
		}
	
}
	catch(Exception e) {
	}
		return response;
	}
}
