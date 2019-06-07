package com.poc.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.Account;
import com.poc.repository.AccountRepository;


@Service
public class QueryOperationsHandlerImpl implements QueryOperationsHandler{
	private static final Logger logger = Logger.getLogger(QueryOperationsHandlerImpl.class.getName());
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountByDisplayId(String _accountDisplayId) {
		return accountRepository.findByAccountDisplayId(_accountDisplayId);
	}

	@Override
	public List<Account> searchAccounts(String _accountDisplayId,
			String _customerDisplayId) {
		return accountRepository.findByAccountDisplayIdOrCustomerDisplayIdContainingIgnoreCase(_accountDisplayId, _customerDisplayId);
	}

	@Override
	public List<Account> getAccountByCustomerDisplayId(String _customerDisplayId) {
		return accountRepository.findByCustomerDisplayIdIgnoreCase(_customerDisplayId);
	}
	


	
}
