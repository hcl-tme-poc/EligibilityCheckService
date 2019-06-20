package com.poc.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.api.EligibilityCheckAPI;
import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.model.DriverDetails;
import com.poc.repository.DriverDetailsRepository;
import com.poc.util.GeneralUtil;

@RunWith(SpringRunner.class)
public class QueryOperationsHandlerImplTests {
	@Mock
	DriverDetailsRepository driverDetailsRepository;
	@Mock
	GeneralUtil generalUtil;
	@Mock
	QueryOperationsHandler queryOperationsHandler;
	@InjectMocks
	private QueryOperationsHandlerImpl queryOperationsHandlerImpl = new QueryOperationsHandlerImpl();
	
	@Test
	public void checkDriverEligibility() {
		
		EligibilityCheckRequestBean request = new EligibilityCheckRequestBean();
		request.setDriverEmail("alex@gmail.com");
		
		DriverDetails driverDetails = new DriverDetails();
		driverDetails.setDriverHealthCardExpDate("2000-01-01");
		driverDetails.setDriverLicenseExpDate("2000-01-01");
		float daysBetween=199.33F;
		
		
		when(driverDetailsRepository.findByDriverEmail(request.getDriverEmail())).thenReturn(driverDetails);
		when(generalUtil.getDateDiff("2000-01-01")).thenReturn(daysBetween);
		
		queryOperationsHandlerImpl.checkDriverEligibility(request);
		
	}
}
