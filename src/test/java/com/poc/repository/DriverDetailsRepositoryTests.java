package com.poc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.model.DriverDetails;

@RunWith(SpringRunner.class)
public class DriverDetailsRepositoryTests {
	@Mock
	DriverDetailsRepository driverDetailsRepository;
	
	@Test
	public void findByDriverEmail() {
		
		DriverDetails details = new DriverDetails();
		details.setDriverEmail("alex@gmail.com");
		
		driverDetailsRepository.findByDriverEmail(details.getDriverEmail());
		
	}

}
