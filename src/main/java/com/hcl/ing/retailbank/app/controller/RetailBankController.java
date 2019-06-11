package com.hcl.ing.retailbank.app.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;
import com.hcl.ing.retailbank.app.dto.LoginRequest;
import com.hcl.ing.retailbank.app.dto.LoginResponse;
import com.hcl.ing.retailbank.app.dto.TransactionDetailsResponse;
import com.hcl.ing.retailbank.app.dto.TransactionResponse;
import com.hcl.ing.retailbank.app.service.LoginService;
import com.hcl.ing.retailbank.app.service.RetailBankService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin("*")
@RequestMapping("/retailbank")
public class RetailBankController {
	
	private static final Logger logger=LogManager.getLogger(RetailBankController.class);
	
	@Autowired
	private RetailBankService retailBankService;
	
	@Autowired
	private LoginService loginService;	
	

	
	@GetMapping("/viewLastTenTransaction/{accountNumber}")
	public TransactionResponse viewLastTenTransactionDetails(@PathVariable Long accountNumber) {
		logger.info("Entering into viewLastTenTransactionDetails() in RetailBankController");
		return retailBankService.viewLastTenTransactionDetails(accountNumber);
	}



	
	
	@PostMapping("/fundTransfer")
	@ApiOperation("Transfer funds from one account to another account")
	public ResponseEntity<FundTransferResponse> transferFunds(@Valid @RequestBody FundTransferRequest request){
		logger.info(this.getClass().getName()+" transferFunds is calling ...!");
		if(request!=null && logger.isDebugEnabled()) {
			logger.debug("FundTransferRequest object is :: "+request.toString());
		}
		return retailBankService.fundTransfer(request);
	}
	
	@GetMapping ("/accountSummary/{acccountNumber}")
	public ResponseEntity<AccountSummaryResponse>  accountSummary(@PathVariable("acccountNumber") Long acccountNumber)
	{
		return retailBankService.accountSummary(acccountNumber);
		
		
	}	
	@PostMapping("/login")
	@ApiOperation("Login to customer to their account")
	public LoginResponse login(@RequestBody LoginRequest request) {
		logger.info("Enter into login controller");
		return loginService.login(request);
		
	}
	
	@GetMapping("/transactionDetails")
	public ResponseEntity<TransactionDetailsResponse> transactionDetails(@RequestParam("transactionId") Long transactionId){
		logger.info(this.getClass().getName()+" transactionDetails is calling ...!");
		if(transactionId!=null && logger.isDebugEnabled()) {
			logger.debug("transactionId is :: "+transactionId);
		}
		return retailBankService.findTransactionById(transactionId);
	}
	

}
