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

import com.poc.beans.AccountRequestBean;
import com.poc.beans.AccountResponseBean;
import com.poc.config.ApplicationConfigurationLoader;
import com.poc.model.Account;
import com.poc.service.AccountManagementProcessor;
import com.poc.validator.AccountRequestBeanValidator;

@RestController
@RequestMapping("/ELIGIBILITY-CHECK/V1.0")
// Swagger Specific Annotations
@Api(value = "LICENSE RENEWAL ELIGIBILITY CHECK", description = "LICENSE RENEWAL ELIGIBILITY CHECK")
public class EligibilityCheckAPI {

	private static final Logger logger = Logger.getLogger(EligibilityCheckAPI.class.getName());

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	@Autowired
	AccountManagementProcessor accountManagementProcessor;

	// VALIDATOR CONFIGURATIONS
	@Autowired
	AccountRequestBeanValidator accountRequestBeanValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(accountRequestBeanValidator);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "LIST ALL ACCOUNTS")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/ACCOUNT/LIST", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Account>> getAllAccounts() {
		logger.log(Level.INFO,
				"Service Name:account-management-service , API Name: getAllAccounts(), Message: Processing Request");
		return new ResponseEntity<List<Account>>(
				accountManagementProcessor.getQueryOperationsHandler().getAllAccounts(), HttpStatus.OK);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "FIND SPECIFIC ACCOUNT")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/ACCOUNT/FIND", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Account> getAccountByDisplayId(
			@RequestParam(name = "accountDisplayId", required = true) String _accountDisplayId) {

		logger.log(Level.INFO,
				"Service Name:account-management-service , API Name: getAccountByDisplayId(), Message: Processing Request");
		return new ResponseEntity<Account>(
				accountManagementProcessor.getQueryOperationsHandler().getAccountByDisplayId(_accountDisplayId),
				HttpStatus.OK);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "SEARCH ACCOUNTS")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/ACCOUNT/SEARCH", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Account>> getAccountByDisplayId(
			@RequestParam(name = "accountDisplayId", required = false) String _accountDisplayId,
			@RequestParam(name = "customerDisplayId", required = false) String _customerDisplayId) {

		logger.log(Level.INFO,
				"Service Name:account-management-service , API Name: searchAccounts(), Message: Processing Request");
		return new ResponseEntity<List<Account>>(accountManagementProcessor.getQueryOperationsHandler()
				.searchAccounts(_accountDisplayId, _customerDisplayId), HttpStatus.OK);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "CREATE ACCOUNT")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 201, message = "SUCCESSFUL RESOURCE CREATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/ACCOUNT/CREATE", method = RequestMethod.POST, produces = { "application/json",
			"application/x-javascript", "application/javascript" }, consumes = { "application/json",
					"application/x-javascript", "application/javascript" })
	public ResponseEntity<AccountResponseBean> createAccount(@Valid @RequestBody AccountRequestBean _request) {

		logger.log(Level.INFO,
				"Service Name:account-management-service , API Name: createAccount(), Message: Processing Request");
		return new ResponseEntity<AccountResponseBean>(
				accountManagementProcessor.getCrudOperationsHandler().createAccount(_request), HttpStatus.CREATED);
	}

	/**
	 * @param _request
	 * @return
	 */
	@ApiOperation(value = "REMOVE ACCOUNT")
	// Swagger Specific Annotation
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL OPERATION"),
			@ApiResponse(code = 401, message = "UNAUTHORIZED TO VIEW RESOURCE"),
			@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
			@ApiResponse(code = 404, message = "RESOURCE NOT FOUND") })
	@RequestMapping(value = "/ACCOUNT/REMOVE", method = RequestMethod.DELETE, produces = { "application/json",
			"application/x-javascript", "application/javascript" })
	public ResponseEntity<AccountResponseBean> removeAccount(
			@RequestParam(name = "accountDisplayId", required = true) String _accountDisplayId) {

		logger.log(Level.INFO,
				"Service Name:account-management-service , API Name: removeAccount(), Message: Processing Request");
		return new ResponseEntity<AccountResponseBean>(
				accountManagementProcessor.getCrudOperationsHandler().removeAccount(_accountDisplayId), HttpStatus.OK);
	}

}
