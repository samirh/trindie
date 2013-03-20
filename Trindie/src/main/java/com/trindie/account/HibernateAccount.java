package com.trindie.account;

import java.net.Proxy.Type;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
@Entity
@Table(name = "ACCOUNT")
public class HibernateAccount implements Account {
	private long ID;
	private String email;
	private String userName;
	private String password;
	private Date createdDate;
	private AccountType type;
	private int version;
	public void setVersion(int version){
		this.version = version;
	}
	@Version
	@Column(name="VERSION")
	public int getVersion(){
		return this.version;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	@Override
	public long getID() {
		return ID;
	}
	public void setID(long id){
		this.ID = id;
	}
	
	@Column(name = "EMAIL")
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "USER_NAME")
	@Override
	public String getUserName() {
		return userName;
	}
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "PASSWORD")
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE)
	@Override
	public Date getCreatedDate() {
		return createdDate;
	}
	@Override
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}
	@Column(name = "ACCOUNT_TYPE")
	@Override
	public AccountType getAccountType() {
		return type;
	}
	@Override
	public void setAccountType(AccountType accountType) {
		this.type = accountType;
	}
	
}
