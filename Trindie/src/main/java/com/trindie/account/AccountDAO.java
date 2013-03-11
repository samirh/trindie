package com.trindie.account;

public interface AccountDAO<T extends Account> {
	
	public void delete(T account);
	public T read(long accountId);
	void save(T account);

}
