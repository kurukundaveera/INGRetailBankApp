package com.hcl.ing.retailbank.app.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retailbank.app.dto.LoginRequest;
import com.hcl.ing.retailbank.app.dto.LoginResponse;
import com.hcl.ing.retailbank.app.entity.AccountSummary;
import com.hcl.ing.retailbank.app.entity.User;
import com.hcl.ing.retailbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retailbank.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	LoginServiceImpl serviceImpl;
	
	@Mock
	AccountSummaryRepository accountSummaryRepository;

	@SuppressWarnings("static-access")
	@Test
	public void testLogin() {
		
		AccountSummary accountSummary=new AccountSummary();
		accountSummary.setAccountName("suma");
		accountSummary.setAccountNo(1L);

		LoginRequest request = new LoginRequest();
		request.setPassword("suma");
		request.setUserName("madhurya");

		
		Optional<User> optional = Optional.empty();

		User user = new User();
		user.setUserId(1L);
		user.setUserName("suma");
		user.setPassword("madhurya");

		optional= Optional.of(user);

		Mockito.when(userRepository.findByUserName("madhurya")).thenReturn(optional);
		Mockito.when(userRepository.findByUserNameAndPassword("madhurya", "suma")).thenReturn(optional);
		Mockito.when(accountSummaryRepository.findByUserId(1L)).thenReturn(accountSummary);

		
		LoginResponse response = new LoginResponse();
		response.setMessage("Login successfull");
		response.setStatus("SUCCESS");
		response.setStatusCode(200);
		response.setAccounNumber(1L);

		LoginResponse actual = serviceImpl.login(request);
		Assert.assertEquals(response.toString(), actual.toString());
	}

}
