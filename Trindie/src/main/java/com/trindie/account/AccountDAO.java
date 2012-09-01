package com.trindie.account;

public interface AccountDAO<T extends Account> {
	
	public T newObject();
	public void create(T account);
	public void delete(String accountId);
	public void update(T account);
	public T read(String accountId);

}
