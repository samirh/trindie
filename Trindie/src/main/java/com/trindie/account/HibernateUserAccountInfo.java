package com.trindie.account;
import javax.persistence.*;
@Entity
@Table(name = "USER_ACCOUNT_INFO")
public class HibernateUserAccountInfo implements UserAccountInfo{
	private long id;
	private String firstName;
	private String lastName;
	private int version;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Override
	public long getID() {
		return id;
	}
	
	public void setID(long id){
		this.id = id;
	}
	@Column(name="FIRST_NAME")
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "LAST_NAME")
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
				
	}
	@Version
	@Column(name = "VERSION")
	public int getVersion(){
		return version;
	}
	public void setVersion(int version){
		this.version = version;
	}

}
