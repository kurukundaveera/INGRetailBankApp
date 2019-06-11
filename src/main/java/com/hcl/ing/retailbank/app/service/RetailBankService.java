package com.hcl.ing.retailbank.app.service;

import com.hcl.ing.retailbank.app.dto.TransactionResponse;

public interface RetailBankService {
	
	TransactionResponse viewLastTenTransactionDetails(Long accountNumber);

}
