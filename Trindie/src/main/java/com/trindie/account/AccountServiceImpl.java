package com.trindie.account;

import java.util.Map;

public class AccountServiceImpl implements AccountService{
	private AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	@Override
	public Account createAccount(Map<String,String> personalInformation) {
		Account account = accountDAO.newObject();
		account.setEmail(personalInformation.get(EMAIL));
		account.setFirstName(personalInformation.get(FIRST_NAME));
		account.setLastName(personalInformation.get(LAST_NAME));
		accountDAO.create(account);
		return account;
	}

	@Override
	public Account get(String accountId) {
		return accountDAO.read(accountId);
	}

	@Override
	public void removeAccount(Account account) {
		accountDAO.delete(account.getID());
	}
	

}
