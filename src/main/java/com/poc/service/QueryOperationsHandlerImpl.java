package com.poc.service;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.beans.EligibilityCheckRequestBean;
import com.poc.beans.EligibilityCheckResponseBean;
import com.poc.beans.ResponseReasons;
import com.poc.model.DriverDetails;
import com.poc.repository.DriverDetailsRepository;
import com.poc.util.GeneralUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class QueryOperationsHandlerImpl implements QueryOperationsHandler{
	private static final Logger logger = Logger.getLogger(QueryOperationsHandlerImpl.class.getName());
	
	@Autowired
	private DriverDetailsRepository driverDetailsRepository;
	
	@Autowired
	private GeneralUtil generalUtil;

	
	@Override
	public EligibilityCheckResponseBean checkDriverEligibility(EligibilityCheckRequestBean _request) {
		
		EligibilityCheckResponseBean eligibilityCheckResponseBean = new EligibilityCheckResponseBean();
		DriverDetails driverDetails = driverDetailsRepository.findByDriverEmail(_request.getDriverEmail().trim());
		
		List<ResponseReasons> reasons = new ArrayList<ResponseReasons>();
		
		eligibilityCheckResponseBean.setMessage("Eligible for License Renewal");
		
		// Check Health Card Expiry
		if(generalUtil.getDateDiff(driverDetails.getDriverHealthCardExpDate())>90) {
			eligibilityCheckResponseBean.setMessage("Not eligible for License Renewal");
			ResponseReasons reason = new ResponseReasons();
			reason.setReasonName("Health Card Expiry");
			reason.setReasonDescription("Health Card is expired for more than 90 days");
			reasons.add(reason);
		}

		
		// Check License Card expiry		
		if(generalUtil.getDateDiff(driverDetails.getDriverLicenseExpDate())>90) {
			eligibilityCheckResponseBean.setMessage("Not eligible for License Renewal");
			ResponseReasons reason = new ResponseReasons();
			reason.setReasonName("License Expiry");
			reason.setReasonDescription("License is expired for more than 90 days");
			reasons.add(reason);
		}

		
		
		eligibilityCheckResponseBean.setReasons(reasons);
		return eligibilityCheckResponseBean;
	}
	
}
