package com.trindie.connection;

import java.util.List;

import com.trindie.common.Connection;

public interface ConnectionDAO {
	public void addConnection(Connection c);
	public void removeConnection(Connection c);
	public List<Connection> getAllConnectionsByPrimary(long primaryId);
	public List<Connection> getAllConnectionsBySecondary(long secondaryId);
	public List<Connection> getConnections(long primaryId,long secondaryId);
	public Connection getConnection(String type,long primaryId,long secondaryId);
	public <T extends Connection> T getConnection(Class<T> c, long primaryId,long secondaryId);

	public List<Connection> getAllConnectionsByPrimary(String type,long primaryId);
	public List<Connection> getAllConnectionsBySecondary(String type, long secondaryId);

	public <T extends Connection> List<T> getAllConnectionsByPrimary(Class<T> c,long primaryId);
	public <T extends Connection> List<T> getAllConnectionsBySecondary(Class<T> c, long secondaryId);
}
