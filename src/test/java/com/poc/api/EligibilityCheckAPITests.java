package com.poc.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.beans.EligibilityCheckResponseBean;
import com.poc.service.EligibiliyCheckProcessor;
import com.poc.service.QueryOperationsHandler;

@RunWith(SpringRunner.class)
public class EligibilityCheckAPITests {

	@Mock
	EligibiliyCheckProcessor eligibiliyCheckProcessor;
	@Mock
	QueryOperationsHandler queryOperationsHandler;
	@Mock
	EligibilityCheckRequestBean eligibilityCheckRequestBean;
	
	@InjectMocks
	private EligibilityCheckAPI checkAPI = new EligibilityCheckAPI();
	@Test
	public void contextLoads() {
	}

	@Test(expected=NullPointerException.class)
	public void doEligibilityCheck() {
		EligibilityCheckRequestBean request = new EligibilityCheckRequestBean();
		EligibilityCheckResponseBean response = new EligibilityCheckResponseBean();
		
		request.setDriverEmail("alex@gmail.com");
		response.setMessage("test");
		response.setReasons(null);
		
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doEligibilityCheck(request);
		assertEquals(HttpStatus.OK, check.getStatusCode());
	}
	
	@Test
	public void doEligibilityCheckGuestValid() {
		String _driverLicenseNumber = "A1234-12345-12345";
		String _trilliumNumber="12345";
		String _postalCode="560040";
		Date _dob = null;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doEligibilityCheckGuest(_driverLicenseNumber, _trilliumNumber, _postalCode, _dob);
		assertEquals(HttpStatus.OK, check.getStatusCode());
	}
	
	@Test
	public void doEligibilityCheckGuestNotValid() {
		String _driverLicenseNumber = "A7869-78965-78965";
		String _trilliumNumber="12345";
		String _postalCode="560040";
		Date _dob = null;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doEligibilityCheckGuest(_driverLicenseNumber, _trilliumNumber, _postalCode, _dob);
		assertEquals(HttpStatus.OK, check.getStatusCode());
	}

	@Test
	public void inValidLicenceNumber() {
		String _driverLicenseNumber = "A7869-78965-11111";
		String _trilliumNumber="12345";
		String _postalCode="560040";
		Date _dob = null;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doEligibilityCheckGuest(_driverLicenseNumber, _trilliumNumber, _postalCode, _dob);
		assertEquals(HttpStatus.UNAUTHORIZED, check.getStatusCode());
	}
	
	@Test
	public void doLicenseQuestionsCheck() {
		String _driverLicenseNumber = "A1234-12345-12345";
		String driverEmail = "alex@gmail.com";
		boolean musclePain = true;
		boolean drivingHabitsStatus = true;
		boolean cardiacStatus= true;
		boolean breathStatus= true;
		boolean eyeVisionStatus= true;
		boolean accidentStatus= true;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doLicenseQuestionsCheck(_driverLicenseNumber, driverEmail, musclePain, drivingHabitsStatus, cardiacStatus, breathStatus, eyeVisionStatus, accidentStatus);
		assertEquals(HttpStatus.OK, check.getStatusCode());
	}
	
	@Test
	public void doLicenseQuestionsCheckNotEligible() {
		String _driverLicenseNumber = "A7869-78965-78965";
		String driverEmail = "alex@gmail.com";
		boolean musclePain = true;
		boolean drivingHabitsStatus = true;
		boolean cardiacStatus= true;
		boolean breathStatus= true;
		boolean eyeVisionStatus= true;
		boolean accidentStatus= true;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doLicenseQuestionsCheck(_driverLicenseNumber, driverEmail, musclePain, drivingHabitsStatus, cardiacStatus, breathStatus, eyeVisionStatus, accidentStatus);
		assertEquals(HttpStatus.UNAUTHORIZED, check.getStatusCode());
	}
	
	@Test
	public void doLicenseQuestionsCheckInValidLicenceNumber() {
		String _driverLicenseNumber = "A7869-78965-11111";
		String driverEmail = "alex@gmail.com";
		boolean musclePain = true;
		boolean drivingHabitsStatus = true;
		boolean cardiacStatus= true;
		boolean breathStatus= true;
		boolean eyeVisionStatus= true;
		boolean accidentStatus= true;
		ResponseEntity<EligibilityCheckResponseBean> check = checkAPI.doLicenseQuestionsCheck(_driverLicenseNumber, driverEmail, musclePain, drivingHabitsStatus, cardiacStatus, breathStatus, eyeVisionStatus, accidentStatus);
		assertEquals(HttpStatus.UNAUTHORIZED, check.getStatusCode());
	}
	
}
