package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibiliyCheckProcessor {

	@Autowired
	private QueryOperationsHandler queryOperationsHandler;

	
	public QueryOperationsHandler getQueryOperationsHandler() {
		return queryOperationsHandler;
	}

}
