package com.trindie.account;

import java.util.Map;

public interface AccountService {
	public static final String EMAIL = "Email";
	public static final String FIRST_NAME = "FirstName";
	public static final String LAST_NAME = "LastName";
	
	public Account createAccount(Map<String,String> personalInformation);
	public Account get(String accountId);
	public void removeAccount(Account account);
}
