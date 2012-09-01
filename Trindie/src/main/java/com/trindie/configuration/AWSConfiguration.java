package com.trindie.configuration;
public class AWSConfiguration {
	private String AWSAccessKey = "AKIAIPPMU7V4PZLDR3XQ";
	private String AWSSecretAccessKey = "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";
	private String AccountTableName = "Accounts";
	public String getAWSAccessKey() {
		return AWSAccessKey;
	}
	public String getAWSSecretAccessKey() {
		return AWSSecretAccessKey;
	}
	public String getAccountTableName() {
		return AccountTableName;
	}
}
