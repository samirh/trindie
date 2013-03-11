package com.trindie.account;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name = "USER_ACCOUNT")
@PrimaryKeyJoinColumn(name="ACCOUNT_ID")
public class HibernateUserAccount extends HibernateAccount implements UserAccount {
	String firstName;
	String lastName;
	int version;
	@Column(name="FIRST_NAME")
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Column(name = "LAST_NAME")
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="VERSION")
	@Version
	public int getVersion(){
		return version;
	}
	
	public void setVersion(int version){
		this.version = version;
	}

}
