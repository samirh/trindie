package com.trindie.account;

import java.util.UUID;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBMapperConfig;

public class DynamoDBAccountDAO implements AccountDAO<DynamoDBAccount>{
	private DynamoDBMapper mapper;
	private DynamoDBMapperConfig  mapperConfig;
	
	public void setMapper(DynamoDBMapper mapper){
		this.mapper = mapper;
	}
	
	public void setMapperConfig(DynamoDBMapperConfig mapperConfig){
		this.mapperConfig = mapperConfig;
	}
	@Override
	public DynamoDBAccount newObject() {
		DynamoDBAccount account = new DynamoDBAccount();
		account.setAccountId(UUID.randomUUID().toString());
		return account;
	}

	@Override
	public void create(DynamoDBAccount account) {
		mapper.save(account,mapperConfig);
	}

	@Override
	public void delete(String accountId) {
		mapper.delete(read(accountId));
	}

	@Override
	public void update(DynamoDBAccount account) {
		mapper.save(account, mapperConfig);
	}

	@Override
	public DynamoDBAccount read(String accountId) {
		return mapper.load(DynamoDBAccount.class, accountId, mapperConfig);
	}


}
