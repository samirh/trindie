package com.trindie.account;

import java.sql.Date;
import java.util.Map;

public class AccountServiceImpl implements AccountService{

	private AccountDAO accountDAO;
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	@Override
	public Account createUserAccount(Map<String, String> personalInformation) {
		Account x = accountDAO.newAccount();
		x.setAccountType(AccountType.USER_ACCOUNT);
		x.setEmail(personalInformation.get(AccountService.EMAIL));
		x.setUserName(personalInformation.get(USERNAME));
		x.setPassword(personalInformation.get(PASSWORD));
		x.setCreatedDate(new Date(System.currentTimeMillis()));
		UserAccountInfo y = accountDAO.newUserAccountInfo();
		y.setFirstName(personalInformation.get(FIRST_NAME));
		y.setLastName(personalInformation.get(LAST_NAME));
		accountDAO.save(x,y);
		return x;
	}

	@Override
	public Account get(long accountId) {
		Account x = accountDAO.readAccount(accountId);
		return x;
	}

	@Override
	public void removeAccount(Account account) {
		accountDAO.deleteAccount(account);
	}
	
		

}
