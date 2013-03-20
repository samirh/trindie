package com.trindie.common;

import com.trindie.connection.ConnectionType;


public interface Connection<K extends IDable,V extends IDable> extends IDable {
	public long getPrimaryObjectID();
	public void setPrimaryObjectID(long primaryObjectID);
	public long getSecondaryObjectID();
	public void setSecondaryObjectID(long secondaryObjectID);
}
