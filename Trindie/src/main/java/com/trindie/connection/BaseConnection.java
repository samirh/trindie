package com.trindie.connection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import com.trindie.common.Connection;
import com.trindie.common.IDable;
@Entity
@Table(name="CONNECTION")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CONNECTION_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class BaseConnection<K extends IDable,V extends IDable> implements Connection<K,V>{
	private long primaryObjectID;	
	private long secondaryObjectID;
	private long id;
	private int version;
	public BaseConnection(K primaryObject, V secondaryObject){
		this.primaryObjectID = primaryObject.getID();
		this.secondaryObjectID = secondaryObject.getID();
	}
	
	public BaseConnection(long primaryObjectID, long secondaryObjectID){
		this.primaryObjectID = primaryObjectID;
		this.secondaryObjectID = secondaryObjectID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONNECTION_ID")
	public long getID(){
		return id;
	}
	
	public void setID(long id){
		this.id = id;
	}
	public void setPrimaryObjectID(long primaryObject){
		this.primaryObjectID = primaryObject;
	}
	public void setSecondaryObjectID(long secondaryObject){
		this.secondaryObjectID = secondaryObject;
	}
	@Column(name="PRIMARY_ID", nullable=false)
	public long getPrimaryObjectID(){
		return primaryObjectID;
	}
	@Column(name="SECONDARY_ID",nullable=false)
	public long getSecondaryObjectID(){
		return secondaryObjectID;
	}
	@Version
	@Column(name="CONNECTION_VERSION")
	public int getVersion(){
		return this.version;
	}
	public void setVersion(int version){
		this.version = version;
	}
	
	public String toString(){
		String s = getClass() +" "+getID()+ " between "+getPrimaryObjectID()+" and "+getSecondaryObjectID();
		return s;
	}
}
