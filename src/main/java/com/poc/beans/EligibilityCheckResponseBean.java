package com.poc.beans;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class EligibilityCheckResponseBean {


	@ApiModelProperty(example="ELIGIBILE / NOT-ELIGIBLE")
	private String message;
	
	private List<ResponseReasons> reasons;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<ResponseReasons> getReasons() {
		return reasons;
	}

	public void setReasons(List<ResponseReasons> reasons) {
		this.reasons = reasons;
	}
	

}
