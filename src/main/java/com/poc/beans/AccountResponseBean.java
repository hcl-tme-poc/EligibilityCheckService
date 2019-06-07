package com.poc.beans;

import io.swagger.annotations.ApiModelProperty;

public class AccountResponseBean {
	
	@ApiModelProperty(example="ACCT1001")
	private String accountDisplayId;
	
	@ApiModelProperty(example="ACCOUNT CREATED/UPDATED/DELETED SUCCESSFULLY")
	private String message;
	
	public String getAccountDisplayId() {
		return accountDisplayId;
	}

	public void setAccountDisplayId(String accountDisplayId) {
		this.accountDisplayId = accountDisplayId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
