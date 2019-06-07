package com.poc.service;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.beans.AccountRequestBean;
import com.poc.beans.AccountResponseBean;
import com.poc.model.Account;
import com.poc.repository.AccountRepository;
import com.poc.util.GeneralUtil;

@Service
public class CRUDOperationsHandlerImpl implements CRUDOperationsHandler {
	
	private static final Logger logger = Logger.getLogger(CRUDOperationsHandlerImpl.class.getName());

	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private AccountRepository accountRepository;


	@Override
	public AccountResponseBean createAccount(AccountRequestBean _request) {
		AccountResponseBean responseBean = new AccountResponseBean();
		try {

			Account accountCreated;

			Account account = new Account();
			account.setAccountDisplayId(generalUtil.createAccountDisplayId());
			account.setAccountName(_request.getAccountName());
			account.setCustomerDisplayId(_request.getCustomerDisplayId());
			accountCreated = accountRepository.save(account);

			
			responseBean.setAccountDisplayId(accountCreated.getAccountDisplayId());
			responseBean.setMessage("ACCOUNT CREATED SUCCESSFULLY");
		} catch (Exception exception) {
			responseBean.setAccountDisplayId(null);
			responseBean.setMessage("ACCOUNT CREATION ERROR "
							+ exception.getMessage());
		}
		return responseBean;
	}

	@Override
	public AccountResponseBean removeAccount(String _accountDisplayId) {
		AccountResponseBean responseBean = new AccountResponseBean();
		try {
			Account account = accountRepository.findByAccountDisplayId(_accountDisplayId);
			if(account == null)
				throw new Exception("ACCOUNT DISPLAY ID INVALID");
			accountRepository.delete(account);

			
			responseBean.setAccountDisplayId(_accountDisplayId);
			responseBean.setMessage("ACCOUNT DELETED SUCCESSFULLY");
		} catch (Exception exception) {
			responseBean.setAccountDisplayId(null);
			responseBean.setMessage("ACCOUNT DELETION ERROR "
							+ exception.getMessage());
		}
		return responseBean;
	}

}
