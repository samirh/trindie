package com.trindie.connection;

import java.util.List;

import com.trindie.common.Connection;

public interface ConnectionService {
	public void addConnection(Connection c);
	public void removeConnection(Connection c);
	public List<Connection> getAllConnectionsByPrimary(ConnectionType type,long primaryId);
	public List<Connection> getAllConnectionsBySecondary(ConnectionType type, long secondaryId);
	public List<Connection> getAllConnectionsByPrimary(long primaryId);
	public List<Connection> getAllConnectionsBySecondary(long secondaryId);
	public List<Connection> getConnections(long primaryId,long secondaryId);
	public Connection getConnection(ConnectionType type,long primaryId,long secondaryId);
}
