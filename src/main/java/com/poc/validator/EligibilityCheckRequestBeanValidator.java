package com.poc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.repository.DriverRegistrationRepository;

@Service
public class EligibilityCheckRequestBeanValidator implements Validator{
	
	
	@Autowired
	private DriverRegistrationRepository driverRegistrationRepository;


	@Override
	public boolean supports(Class<?> clazz) {
		return EligibilityCheckRequestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors _errors) {
		EligibilityCheckRequestBean eligibilityCheckRequestBeanRequest = (EligibilityCheckRequestBean) target;
		
		
		if(driverRegistrationRepository.findByDriverEmail(eligibilityCheckRequestBeanRequest.getDriverEmail().trim())==null){
			_errors.reject("DRIVER EMAIL DOES NOT EXISTS","DRIVER EMAIL DOES NOT EXISTS");
		}
		
	
	}

}
