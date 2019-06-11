package com.hcl.ing.retailbank.app.service;

import org.springframework.http.ResponseEntity;

import com.hcl.ing.retailbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;
import com.hcl.ing.retailbank.app.dto.TransactionDetails;
import com.hcl.ing.retailbank.app.dto.TransactionDetailsResponse;
import com.hcl.ing.retailbank.app.dto.TransactionResponse;

public interface RetailBankService {
	
	TransactionResponse viewLastTenTransactionDetails(Long accountNumber);

	
	/**
	 * This API  For TRANSFER FUNDS
	 * @param request
	 * @return
	 */
	public ResponseEntity<FundTransferResponse> fundTransfer(FundTransferRequest request);

	public ResponseEntity<AccountSummaryResponse> accountSummary(Long acccountNumber);
	
	public ResponseEntity<TransactionDetailsResponse> findTransactionById(Long transactionId);

}
