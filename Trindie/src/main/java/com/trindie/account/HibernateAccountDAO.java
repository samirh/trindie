package com.trindie.account;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDAO")
@Transactional
public class HibernateAccountDAO implements AccountDAO<HibernateAccount,HibernateUserAccountInfo> {
	SessionFactory sessionFactory;
	private Logger log = Logger.getLogger(HibernateAccountDAO.class);
	private final static String READ_ACCOUNT_BY_ID = "select distinct c from Account a  where c.ID = :id";
	private final static String READ_USER_ACCOUNT_INFO_BY_ID = "select distinct c from UserAccountInfo a  where c.ID = :id";
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
	public void deleteAccount(HibernateAccount account) {
		sessionFactory.getCurrentSession().delete(account);
		log.info("Account deleted with id:"+account.getID());
	}

	@Override
	@Transactional(readOnly=true)
	public HibernateAccount readAccount(long accountId) {
		log.info("Account read with id: "+accountId);
		return (HibernateAccount) sessionFactory.getCurrentSession().createQuery(READ_ACCOUNT_BY_ID).setParameter("id",accountId).uniqueResult();
	}


	@Override
	public HibernateAccount newAccount() {
		return new HibernateAccount();
	}


	@Override
	public HibernateUserAccountInfo newUserAccountInfo() {
		return new HibernateUserAccountInfo();
	}


	@Override
	public void deleteUserAccountInfo(HibernateUserAccountInfo userAccountInfo) {
		sessionFactory.getCurrentSession().delete(userAccountInfo);
		log.info("Deleted UserAccountInfo for id: "+userAccountInfo.getID());
	}


	@Override
	@Transactional(readOnly=true)
	public HibernateUserAccountInfo readUserAccountInfo(long userAccountInfoId) {
		log.info("UserAccountInfo read with id: "+userAccountInfoId);
		return (HibernateUserAccountInfo) sessionFactory.getCurrentSession().createQuery(READ_USER_ACCOUNT_INFO_BY_ID).setParameter("id",userAccountInfoId).uniqueResult();
	}


	@Override
	public void save(HibernateAccount account,
			HibernateUserAccountInfo userAccountInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
		log.info("Account saved with id: "+account.getID());
		sessionFactory.getCurrentSession().saveOrUpdate(userAccountInfo);
		log.info("UserAccountInfo saved with id: "+userAccountInfo.getID());
	}


	@Override
	public void save(HibernateUserAccountInfo userAccountInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(userAccountInfo);
		log.info("UserAccountInfo saved with id: "+userAccountInfo.getID());
	}

	

}
