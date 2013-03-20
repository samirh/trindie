package com.trindie.connection;

import java.util.HashMap;
import java.util.Map;

import com.trindie.account.connections.UserAccountInfoConnection;
import com.trindie.common.*;
public final class ConnectionType {
	public static final String USER_ACCOUNT_INFO = "USER_ACCOUNT_INFO";
	private static final Map<Class<?>,String> classMapper;
	static{
		classMapper = new HashMap<Class<?>,String>();
		classMapper.put(UserAccountInfoConnection.class, USER_ACCOUNT_INFO);
		
	}
	
	public static final <T extends Connection> String valueOf(Class<T> c){
		return classMapper.get(c);
	}
}
