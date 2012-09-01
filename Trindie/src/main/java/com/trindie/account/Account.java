package com.trindie.account;

public interface Account {
	public String getAccountId();
	public String getEmail();
	public String getFirstName();
	public String getLastName();
	public void setEmail(String email);
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
}
