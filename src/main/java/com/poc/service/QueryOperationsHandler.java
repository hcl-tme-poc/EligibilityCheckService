package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.beans.EligibilityCheckResponseBean;

@Service
public interface QueryOperationsHandler{
	
	public EligibilityCheckResponseBean checkDriverEligibility(EligibilityCheckRequestBean _request);
	

}
