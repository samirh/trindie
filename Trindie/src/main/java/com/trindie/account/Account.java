package com.trindie.account;

import java.util.Date;

import com.trindie.common.IDable;


public interface Account extends IDable {
	public String getEmail();
	public void setEmail(String email);
	public String getUserName();
	public void setUserName(String userName);
	String getPassword();
	void setPassword(String password);
	public Date getCreatedDate();
	public void setCreatedDate(Date date);
	public AccountType getAccountType();
	public void setAccountType(AccountType accountType);	
}
