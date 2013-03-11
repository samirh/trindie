package com.trindie.account;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.GenerationType;
@Entity
@Table(name = "ACCOUNT")
@Inheritance(strategy=InheritanceType.JOINED)
public class HibernateAccount implements Account {
	private long ID;
	private String email;
	private String userName;
	private String password;
	private Date createdDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	@Override
	public long getID() {
		return ID;
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
	@Column(name = "DATE")
	@Override
	public Date getCreatedDate() {
		return createdDate;
	}
	@Override
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}
	@Override
	public void setID(long id) {
		// TODO Auto-generated method stub
		
	}
}
