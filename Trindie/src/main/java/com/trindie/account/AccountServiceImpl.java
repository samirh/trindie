package com.trindie.account;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.trindie.account.connections.HibernateUserAccountInfoConnection;
import com.trindie.account.connections.UserAccountInfoConnection;
import com.trindie.connection.ConnectionDAO;

public class AccountServiceImpl implements AccountService{

	private AccountDAO accountDAO;
	private ConnectionDAO connectionDAO;
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	public void setConnectionDAO(ConnectionDAO connectionDAO){
		this.connectionDAO = connectionDAO;
	}
	
	@Override
	@Transactional
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
		createUserAccountInfoConnection(x,y);
		
		return x;
	}

	private UserAccountInfoConnection createUserAccountInfoConnection(Account x, UserAccountInfo y) {
		UserAccountInfoConnection c = new HibernateUserAccountInfoConnection(x, y);
		connectionDAO.addConnection(c);
		return c;
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
