package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManagementProcessor {

	@Autowired
	private QueryOperationsHandler queryOperationsHandler;
	
	@Autowired
	private CRUDOperationsHandler crudOperationsHandler;
	
	public QueryOperationsHandler getQueryOperationsHandler() {
		return queryOperationsHandler;
	}

	public CRUDOperationsHandler getCrudOperationsHandler() {
		return crudOperationsHandler;
	}

}
