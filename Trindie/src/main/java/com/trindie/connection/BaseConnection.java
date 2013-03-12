package com.trindie.connection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Version;

import com.trindie.common.Connection;
import com.trindie.common.IDable;
@Entity
@Table(name="CONNECTION")
public class BaseConnection<K extends IDable,V extends IDable> implements Connection<K,V>{
	private long primaryObjectID;	
	private long secondaryObjectID;
	private long id;
	private int version;
	private ConnectionType type;
	public BaseConnection(ConnectionType type,K primaryObject, V secondaryObject){
		this.primaryObjectID = primaryObject.getID();
		this.secondaryObjectID = secondaryObject.getID();
		this.type = type;
	}
	
	public BaseConnection(ConnectionType type,long primaryObjectID, long secondaryObjectID){
		this.primaryObjectID = primaryObjectID;
		this.secondaryObjectID = secondaryObjectID;
		this.type = type;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONNECTION_ID")
	public long getID(){
		return id;
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
	@Column(name="CONNECTION_TYPE")
	@Override
	public ConnectionType getConnectionType() {
		return type;
	}
	public void setConnectionType(ConnectionType connectionType){
		this.type = connectionType;
	}
	
}
