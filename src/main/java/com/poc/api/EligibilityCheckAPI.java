package com.poc.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.beans.EligibilityCheckResponseBean;
import com.poc.beans.ResponseReasons;
import com.poc.config.ApplicationConfigurationLoader;
import com.poc.service.EligibiliyCheckProcessor;
import com.poc.validator.EligibilityCheckRequestBeanValidator;

@RestController
@RequestMapping("/ELIGIBILITY-CHECK/V1.0")
// Swagger Specific Annotations
@Api(value = "LICENSE RENEWAL ELIGIBILITY CHECK", description = "LICENSE RENEWAL ELIGIBILITY CHECK")
@Validated
public class EligibilityCheckAPI {

	private static final Logger logger = Logger.getLogger(EligibilityCheckAPI.class.getName());

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	@Autowired
	EligibiliyCheckProcessor eligibiliyCheckProcessor;

	// VALIDATOR CONFIGURATIONS
	@Autowired
	EligibilityCheckRequestBeanValidator requestBeanValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(requestBeanValidator);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CHECK DRIVER'S LICENSE RENEWAL ELIGIBILITY")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/DRIVER/ELIGIBILITY-CHECK", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<EligibilityCheckResponseBean> doEligibilityCheck(@Valid @RequestBody EligibilityCheckRequestBean _request) {

		return new ResponseEntity<EligibilityCheckResponseBean>(
				eligibiliyCheckProcessor.getQueryOperationsHandler().checkDriverEligibility(_request), HttpStatus.OK);
	}
	
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CHECK LICENSE RENEWAL ELIGIBILITY FOR GUEST USERS")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/GUEST-DRIVER/ELIGIBILITY-CHECK", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<EligibilityCheckResponseBean> doEligibilityCheckGuest(
			@RequestParam(name = "driverLicenseNumber", required = true) 
			@Size(min= 17, message = "Driver License must be 17 characters") 
			String _driverLicenseNumber,
			@RequestParam(name = "trilliumNumber", required = true) String _trilliumNumber,
			@RequestParam(name = "postalCode", required = true) 
			@Size(min= 6, message = "Postal Code must be 6 digits") 
			String _postalCode,
			@RequestParam(name = "dob", required = true) Date _dob) {
		
		if(_driverLicenseNumber.equalsIgnoreCase("A1234-12345-12345")) {
			
			EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
			List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
			
			eligibilityCheckResponseBean.setMessage("You are eligible to renew your driver’s license");
			
			return new ResponseEntity<EligibilityCheckResponseBean>(
					eligibilityCheckResponseBean, HttpStatus.OK);
			
		}
		if(_driverLicenseNumber.equalsIgnoreCase("A7869-78965-78965")) {
			
			EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
			List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
			
			eligibilityCheckResponseBean.setMessage("You are not eligible to renew your driver’s license");
			ResponseReasons reason1 = new ResponseReasons();
			reason1.setReasonName("Health Card Expiry");
			reason1.setReasonDescription("Health Card is expired for more than 90 days");
			reasons.add(reason1);
			
			ResponseReasons reason2 = new ResponseReasons();
			reason2.setReasonName("License Card Expiry");
			reason2.setReasonDescription("License Card is expired for more than 90 days");
			reasons.add(reason2);
			
			eligibilityCheckResponseBean.setReasons(reasons);
			
			return new ResponseEntity<EligibilityCheckResponseBean>(
					eligibilityCheckResponseBean, HttpStatus.OK);
			
		}

		
		
		EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
		List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
		
		eligibilityCheckResponseBean.setMessage("Information provided does not match");
		ResponseReasons reason1 = new ResponseReasons();
		reason1.setReasonName("License Number");
		reason1.setReasonDescription("License Number provided does not match");
		reasons.add(reason1);
		
		ResponseReasons reason2 = new ResponseReasons();
		reason2.setReasonName("Trillium Number");
		reason2.setReasonDescription("Trillium Number provided does not match");
		reasons.add(reason2);
		
		eligibilityCheckResponseBean.setReasons(reasons);
		
		return new ResponseEntity<EligibilityCheckResponseBean>(
				eligibilityCheckResponseBean, HttpStatus.UNAUTHORIZED);
	}


	
	
	
	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CHECK LICENSE QUESTIONS FOR DRIVERS")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/GUEST-DRIVER/ELIGIBILITY-QUESTION-CHECK", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<EligibilityCheckResponseBean> doLicenseQuestionsCheck(
			@RequestParam(name = "driverLicenseNumber", required = true) 
			@Size(min= 17, message = "Driver License must be 17 characters") 
			String _driverLicenseNumber,
			
			@RequestParam(name = "driverEmail", required = true) 
			String driverEmail,
			
			@RequestParam(name = "musclePain", required = true) 
			boolean musclePain,
			
			@RequestParam(name = "drivingHabitsStatus", required = true) 
			boolean drivingHabitsStatus,
			
			@RequestParam(name = "cardiacStatus", required = true) 
			boolean cardiacStatus,
			
			@RequestParam(name = "breathStatus", required = true) 
			boolean breathStatus,
			
			@RequestParam(name = "eyeVisionStatus", required = true) 
			boolean eyeVisionStatus,
			
			@RequestParam(name = "accidentStatus", required = true) 
			boolean accidentStatus
			
			
			) {
		
		if(_driverLicenseNumber.equalsIgnoreCase("A1234-12345-12345")) {
			
			EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
			List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
			
			eligibilityCheckResponseBean.setMessage("You are eligible to renew your driver’s license");
			
			
			
			if(musclePain) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Muscle Pain");
				reason.setReasonDescription("You need to visit MTO center for Medical-chekup");
				reasons.add(reason);
			}
			if(eyeVisionStatus) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Eye vision");
				reason.setReasonDescription("You need to visit MTO center for vision test");
				reasons.add(reason);
			}
			if(drivingHabitsStatus) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Driving Habits");
				reason.setReasonDescription("You need to visit MTO with chargeable action and report provided to you by authority.");
				reasons.add(reason);
			}
			
			if(cardiacStatus) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Cardiac");
				reason.setReasonDescription("You need to visit MTO with previous cardiac medical report and prescription provided");
				reasons.add(reason);
			}
			
			if(breathStatus) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Breadth");
				reason.setReasonDescription("You need to visit MTO center for respiratory related Medical-checkup.");
				reasons.add(reason);
			}
			
			if(accidentStatus) {
				ResponseReasons reason = new ResponseReasons();
				reason.setReasonName("Breadth");
				reason.setReasonDescription("You need to visit MTO center for complete previous medical report while hospitalization and accident case report.");
				reasons.add(reason);
			}


			eligibilityCheckResponseBean.setReasons(reasons);
			return new ResponseEntity<EligibilityCheckResponseBean>(
					eligibilityCheckResponseBean, HttpStatus.OK);
			
		}
		if(_driverLicenseNumber.equalsIgnoreCase("A7869-78965-78965")) {
			
			EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
			List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
			
			eligibilityCheckResponseBean.setMessage("You are not eligible to renew your driver’s license");
			ResponseReasons reason1 = new ResponseReasons();
			reason1.setReasonName("Health Card Expiry");
			reason1.setReasonDescription("Health Card is expired for more than 90 days");
			reasons.add(reason1);
			
			ResponseReasons reason2 = new ResponseReasons();
			reason2.setReasonName("License Card Expiry");
			reason2.setReasonDescription("License Card is expired for more than 90 days");
			reasons.add(reason2);
			
			eligibilityCheckResponseBean.setReasons(reasons);
			
			return new ResponseEntity<EligibilityCheckResponseBean>(
					eligibilityCheckResponseBean, HttpStatus.UNAUTHORIZED);
			
		}

		
		
		EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
		List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
		
		eligibilityCheckResponseBean.setMessage("Information provided does not match");
		ResponseReasons reason1 = new ResponseReasons();
		reason1.setReasonName("License Number");
		reason1.setReasonDescription("License Number provided does not match");
		reasons.add(reason1);
		
	
		eligibilityCheckResponseBean.setReasons(reasons);
		
		return new ResponseEntity<EligibilityCheckResponseBean>(
				eligibilityCheckResponseBean, HttpStatus.UNAUTHORIZED);
	}

}
