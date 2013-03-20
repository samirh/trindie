package com.trindie.connection;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trindie.account.HibernateAccountDAO;
import com.trindie.common.Connection;
@Repository("connectionDAO")
@Transactional
public class HibernateConnectionDAO implements ConnectionDAO{
	SessionFactory sessionFactory;
	private Logger log = LoggerFactory.getLogger(HibernateConnectionDAO.class);
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		log.info("sessionFactory defined");
	}
	private static final StringBuilder initialMatchCondition(String s){
		return new StringBuilder(s);
	}
	private static final StringBuilder addMatchCondition(StringBuilder b, String s){
		b.append(" AND ");
		b.append(s);
		return b;
	}
	@Override
	public void addConnection(Connection c) {
		
		sessionFactory.getCurrentSession().save(c);
		log.info("Connection created "+ c.toString());
	}

	@Override
	public void removeConnection(Connection c) {
		sessionFactory.getCurrentSession().delete(c);
		log.info("Connection removed "+c.toString());
	}

	@Override
	public List<Connection> getAllConnectionsByPrimary(long primaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> getAllConnectionsBySecondary(long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> getConnections(long primaryId, long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String type, long primaryId,
			long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Connection> T getConnection(Class<T> c, long primaryId,
			long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> getAllConnectionsByPrimary(String type,
			long primaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> getAllConnectionsBySecondary(String type,
			long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Connection> List<T> getAllConnectionsByPrimary(
			Class<T> c, long primaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Connection> List<T> getAllConnectionsBySecondary(
			Class<T> c, long secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
