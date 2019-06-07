package com.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNT")
public class Account {
	

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="ACCOUNT_ID")
    private Long id;
	
	@Column(name="ACCOUNT_DISPLAY_ID")
    @NotNull
	private String accountDisplayId;
	
    @Column(name="ACCOUNT_NAME")
    @NotNull
	private String accountName;
    
	@Column(name="CUSTOMER_DISPLAY_ID")
    @NotNull
	private String customerDisplayId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountDisplayId() {
		return accountDisplayId;
	}

	public void setAccountDisplayId(String accountDisplayId) {
		this.accountDisplayId = accountDisplayId;
	}

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
