package com.hcl.ing.retailbank.app.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.ing.retailbank.app.dto.FundTransferRequest;
import com.hcl.ing.retailbank.app.dto.FundTransferResponse;
import com.hcl.ing.retailbank.app.entity.AccountSummary;
import com.hcl.ing.retailbank.app.entity.TransactionHistory;
import com.hcl.ing.retailbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retailbank.app.repository.TransactionHistoryRepository;
import com.hcl.ing.retailbank.app.util.InSufficientFundsException;
import com.hcl.ing.retailbank.app.util.RetailBankServiceException;
import com.hcl.ing.retailbank.app.util.TransactionType;

@Service
public class RetailBankServiceImpl implements RetailBankService {
	
	private static final Logger logger=LogManager.getLogger(RetailBankServiceImpl.class);
	
	private static final String SUCCESS="SUCCESS";
	
	private static final String FAILURE="FAILURE";
	
	@Autowired
	private AccountSummaryRepository accountSummaryRepository;
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	
	/*
	 * Transfer funds from one account to another account
	 */
	@Override
	public ResponseEntity<FundTransferResponse> fundTransfer(FundTransferRequest request) {
		FundTransferResponse response=null;
		try {
			if(request!=null) {
				
				Long fromAccount = request.getFromAccount();
				if(fromAccount!=null) {
					//checking source account existed or not
					AccountSummary accountSummary = accountSummaryRepository.findByAccountNo(fromAccount);
					if(accountSummary!=null) {
						//checking destination account existed or not
						AccountSummary toAccountSummary = accountSummaryRepository.findByAccountNo(request.getToAccount());
						if(toAccountSummary!=null) {
							Double closingBalance = accountSummary.getClosingBalance();
							if(closingBalance>=request.getAmount()) {
								double fromBalance=closingBalance-request.getAmount();
								double toBalance=toAccountSummary.getClosingBalance()+request.getAmount();
								
								// updating source account closing amount after transaction
								accountSummary.setClosingBalance(fromBalance);
								accountSummaryRepository.save(accountSummary);
								
								// updating destination account closing amount after transaction
								toAccountSummary.setClosingBalance(toBalance);
								accountSummaryRepository.save(toAccountSummary);
								
								
								//source account transaction
								TransactionHistory sourceTransaction=new TransactionHistory();
								sourceTransaction.setFromAccountNo(request.getFromAccount());
								sourceTransaction.setToAccountNo(request.getToAccount());
								sourceTransaction.setClosingBalance(fromBalance);
								sourceTransaction.setComments(request.getComments());
								sourceTransaction.setCreateDt(new Date());
								sourceTransaction.setTransactionType(TransactionType.DEBIT.toString());
								
								//destination account transaction
								TransactionHistory destinaitonTransaction=new TransactionHistory();
								destinaitonTransaction.setFromAccountNo(request.getToAccount());
								destinaitonTransaction.setToAccountNo(request.getFromAccount());
								destinaitonTransaction.setClosingBalance(toBalance);
								destinaitonTransaction.setComments(request.getComments());
								destinaitonTransaction.setCreateDt(new Date());
								destinaitonTransaction.setTransactionType(TransactionType.CREDIT.toString());
								
								transactionHistoryRepository.save(sourceTransaction);
								transactionHistoryRepository.save(destinaitonTransaction);
								
								response=new FundTransferResponse();
								response.setStatusCode(200);
								response.setStatus(SUCCESS);
								response.setMessage("Your funds transferred successfully ...!");
								
							}else {
								throw new InSufficientFundsException("Sorry, Insufficient funds in your account ...!");
							}
						}else {
							throw new RetailBankServiceException("Destination account is not found ...!");
						}
					}else {
						throw new RetailBankServiceException("Source account is not found ...!");
					}
				}else {
					throw new RetailBankServiceException("Source account is null");
				}
				
			}else {
				logger.error("FundTransferRequest is null ...!");
			}
			
		}catch(Exception e) {
			response=new FundTransferResponse();
			response.setStatusCode(500);
			response.setStatus(FAILURE);
			response.setMessage(e.getMessage());
			logger.error(this.getClass().getName()+" - fundTransfer : "+e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
}
