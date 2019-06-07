package com.poc.beans;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AccountRequestBean {
	

	@NotNull(message="ACCOUNT NAME CANNOT BE NULL")
	@NotBlank(message="ACCOUNT NAME CANNOT BE BLANK")
	@ApiModelProperty(example="ACCOUNT NAME")
	private String accountName;
	
	@NotNull(message="CUSTOMER ID CANNOT BE NULL")
	@NotBlank(message="CUSTOMER ID CANNOT BE BLANK")
	@ApiModelProperty(example="CUSTOMER DISPLAY ID")
	private String customerDisplayId;
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCustomerDisplayId() {
		return customerDisplayId;
	}

	public void setCustomerDisplayId(String customerDisplayId) {
		this.customerDisplayId = customerDisplayId;
	}


}
