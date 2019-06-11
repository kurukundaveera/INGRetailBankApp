package com.hcl.ing.retailbank.app.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retailbank.app.controller.RetailBankController;
import com.hcl.ing.retailbank.app.dto.LoginRequest;
import com.hcl.ing.retailbank.app.dto.LoginResponse;
import com.hcl.ing.retailbank.app.entity.AccountSummary;
import com.hcl.ing.retailbank.app.entity.User;
import com.hcl.ing.retailbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retailbank.app.repository.UserRepository;
import com.hcl.ing.retailbank.app.util.RetailBankServiceException;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LogManager.getLogger(RetailBankController.class);

	private static final String SUCCESS = "SUCCESS";
	private static final String FAILURE = "FAILURE";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;

	@Override
	public LoginResponse login(LoginRequest request) {
		logger.info("Enter into login service impl");

		LoginResponse response = null;

		try {
			if (request != null) {

				response = new LoginResponse();

				Optional<User> userMail = userRepository.findByUserName(request.getUserName());

				if (!userMail.isPresent()) {

					throw new RetailBankServiceException("User Not Found");

				}

				Optional<User> user = userRepository.findByUserNameAndPassword(request.getUserName(),
						request.getPassword());

				if (!user.isPresent()) {

					throw new RetailBankServiceException("Invalid credential Exception");
				}

				if (user.isPresent()) {

					AccountSummary accountSummary = accountSummaryRepository.findByUserId(user.get().getUserId());

					response.setMessage("Login successfull");
					response.setStatus(SUCCESS);
					response.setStatusCode(200);
					response.setAccounNumber(accountSummary.getAccountNo());
				}

			} else {
				throw new RetailBankServiceException("Request Not found");
			}

		} catch (Exception e) {

			response = new LoginResponse();
			response.setMessage(e.getMessage());
			response.setStatus(FAILURE);
			response.setStatusCode(404);
			response.setAccounNumber(0L);
			logger.error(getClass().getName() + "  " + " login " + e.getMessage());

		}

		return response;
	}

}
