package com.trindie.controllers;

import java.util.HashMap;
import java.util.Map;
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

@Controller
@RequestMapping(value="/account")
public class AccountController {
	final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/sayhi", method = RequestMethod.GET)
	@ResponseBody
	public Account sayHi(){
		Map<String,String> pi = new HashMap<String,String>();
		pi.put(AccountService.EMAIL,"samir8@gmail.com");
		pi.put(AccountService.FIRST_NAME,"Samir");
		pi.put(AccountService.LAST_NAME, "Hegde");
		pi.put(AccountService.PASSWORD, "oadjaskdaskd");
		pi.put(AccountService.USERNAME, "samix");
		Account x = accountService.createUserAccount(pi);
		return x;
	}
	
}
