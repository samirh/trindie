package com.trindie.account;

import java.util.Map;

public interface AccountService {
	public static final String EMAIL = "Email";
	public static final String FIRST_NAME = "FirstName";
	public static final String LAST_NAME = "LastName";
	public static final String USERNAME = "UserName";
	public static final String PASSWORD = "Password";
	
	public Account get(long accountId);
	public void removeAccount(Account account);
	Account createUserAccount(Map<String, String> personalInformation);
}
