package com.trindie.account;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBVersionAttribute;

public class DynamoDBAccount implements Account {
	String accountId;
	String email;
	String firstName;
	String lastName;
	Long versionNumber;
	
	@DynamoDBHashKey(attributeName="LN")
	@Override
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId){
		this.accountId = accountId;
	}
	
	@DynamoDBAttribute(attributeName="E")
	@Override
	public String getEmail() {
		return email;
	}
	@DynamoDBAttribute(attributeName="FN")
	@Override
	public String getFirstName() {
		return firstName;
	}
	@DynamoDBAttribute(attributeName="LN")
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DynamoDBVersionAttribute
	public Long getVersionNumber(){
		return versionNumber;
	}
	public void setVersionNumber(Long versionNumber){
		this.versionNumber = versionNumber;
	}
	
}
