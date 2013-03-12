package com.trindie.account;

public interface AccountDAO<T extends Account, U extends UserAccountInfo>{
	public T newAccount();
	public U newUserAccountInfo();
	public void deleteAccount(T account);
	public void deleteUserAccountInfo(U userAccountInfo);
	public T readAccount(long accountId);
	public U readUserAccountInfo(long userAccountInfoId);
	void save(T account);
	void save(T account, U userAccountInfo);
	void save(U userAccountInfo);
}
