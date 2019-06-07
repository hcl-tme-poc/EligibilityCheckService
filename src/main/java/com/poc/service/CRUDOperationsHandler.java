package com.poc.service;

import org.springframework.stereotype.Service;

import com.poc.beans.AccountRequestBean;
import com.poc.beans.AccountResponseBean;

@Service
public interface CRUDOperationsHandler{
	
	public AccountResponseBean createAccount(AccountRequestBean _request);

	public AccountResponseBean removeAccount(String _accountDisplayId);
	
	

}
