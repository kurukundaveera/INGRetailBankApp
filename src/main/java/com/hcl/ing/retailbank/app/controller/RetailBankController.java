package com.hcl.ing.retailbank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retailbank.app.service.RetailBankService;

@RestController
@RequestMapping("/retailbank")
@CrossOrigin
public class RetailBankController {
	
	private static final Logger logger=LogManager.getLogger(RetailBankController.class);

	@Autowired
	RetailBankService retailBankService;
	@GetMapping ("/accountSummary/{acccountNumber}")
	public ResponseEntity<AccountSummaryResponse>  accountSummary(@PathVariable("acccountNumber") Long acccountNumber)
	{
		ResponseEntity<AccountSummaryResponse> accountSummaryResponse=retailBankService.accountSummary(acccountNumber);
		return accountSummaryResponse;
		
	}
}
