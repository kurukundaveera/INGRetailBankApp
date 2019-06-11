package com.hcl.ing.retailbank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retailbank.app.dto.TransactionResponse;
import com.hcl.ing.retailbank.app.service.RetailBankService;

@RestController
@RequestMapping("/retailbank")
@CrossOrigin
public class RetailBankController {
	
	private static final Logger logger=LogManager.getLogger(RetailBankController.class);
	
	@Autowired
	private RetailBankService retailBankService;
	
	@GetMapping("/viewLastTenTransaction/{accountNumber}")
	public TransactionResponse viewLastTenTransactionDetails(@PathVariable Long accountNumber) {
		logger.info("Entering into viewLastTenTransactionDetails() in RetailBankController");
		return retailBankService.viewLastTenTransactionDetails(accountNumber);
	}

}

