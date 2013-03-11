package com.trindie.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trindie.account.Account;
import com.trindie.account.AccountService;
import com.trindie.account.DynamoDBAccount;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/sayhi", method = RequestMethod.GET)
	@ResponseBody
	public Account sayHi(){
		DynamoDBAccount x = new DynamoDBAccount();
		x.setEmail("samir8@gmail.com");
		x.setFirstName("Samir");
		x.setLastName("Hegde");
		x.setAccountId(UUID.randomUUID().toString());
		return x;
	}
	
}
