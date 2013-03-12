package com.trindie.account;
import com.trindie.common.IDable;

public interface UserAccountInfo extends IDable {
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
}
