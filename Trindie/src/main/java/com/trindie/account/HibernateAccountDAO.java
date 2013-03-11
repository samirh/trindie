package com.trindie.account;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDAO")
@Transactional
public class HibernateAccountDAO implements AccountDAO<HibernateAccount> {
	SessionFactory sessionFactory;
	private Logger log = Logger.getLogger(HibernateAccountDAO.class);
	private final static String READ_BY_ID = "select distinct c from Account a  where c.ID = :id";
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		log.info("sessionFactory defined");
	}
	

	@Override
	public void save(HibernateAccount account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
		log.info("Account saved with id: "+account.getID());
	}

	@Override
	public void delete(HibernateAccount account) {
		sessionFactory.getCurrentSession().delete(account);
		log.info("Account deleted with id:"+account.getID());
	}

	@Override
	@Transactional(readOnly=true)
	public HibernateAccount read(long accountId) {
		log.info("Account read with id: "+accountId);
		return (HibernateAccount) sessionFactory.getCurrentSession().createQuery(READ_BY_ID).setParameter("id",accountId).uniqueResult();
	}

	

}
