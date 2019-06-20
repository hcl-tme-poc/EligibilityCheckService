package com.poc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DriverRegistrationRepositoryTests {
	@Mock
	DriverRegistrationRepository driverRegistrationRepository;
	@Test
	public void findByDriverEmail() {
		
		driverRegistrationRepository.findByDriverEmail("alex@gmail.com");
	}

}
