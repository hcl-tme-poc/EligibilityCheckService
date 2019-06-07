package com.poc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.model.Account;


public interface AccountRepository extends JpaRepository<Account, Serializable>{
	
	public List<Account> findByCustomerDisplayIdIgnoreCase(String _customerDisplayId);
	
	public Account findByAccountDisplayId(String _accountDisplayId);
	
	public Account findByAccountName(String _accountName);
	
	public List<Account> findByAccountDisplayIdOrCustomerDisplayIdContainingIgnoreCase(String _accountDisplayId,String _customerDisplayId);

}
