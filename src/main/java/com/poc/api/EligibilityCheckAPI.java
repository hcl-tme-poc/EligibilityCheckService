package com.poc.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.beans.EligibilityCheckResponseBean;
import com.poc.config.ApplicationConfigurationLoader;
import com.poc.service.EligibiliyCheckProcessor;
import com.poc.validator.EligibilityCheckRequestBeanValidator;

@RestController
@RequestMapping("/ELIGIBILITY-CHECK/V1.0")
// Swagger Specific Annotations
@Api(value = "LICENSE RENEWAL ELIGIBILITY CHECK", description = "LICENSE RENEWAL ELIGIBILITY CHECK")
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



}
