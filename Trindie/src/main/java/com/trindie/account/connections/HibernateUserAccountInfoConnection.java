package com.trindie.account.connections;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.trindie.account.Account;
import com.trindie.account.UserAccountInfo;
import com.trindie.connection.BaseConnection;
import com.trindie.connection.ConnectionType;

public class HibernateUserAccountInfoConnection extends BaseConnection<Account,UserAccountInfo> implements UserAccountInfoConnection {
	public HibernateUserAccountInfoConnection(Account primary, UserAccountInfo secondary){
		super(ConnectionType.USER_ACCOUNT_INFO,primary,secondary);
	}
}
