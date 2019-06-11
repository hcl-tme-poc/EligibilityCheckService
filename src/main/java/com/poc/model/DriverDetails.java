package com.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DRIVER_DETAILS")
public class DriverDetails {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="DRIVER_DETAILS_ID")
    private Long id;
	
	@Column(name="DRIVER_FNAME")
    @NotNull
	private String driverFName;
	
	@Column(name="DRIVER_LNAME")
	private String driverLName;
	
	@Column(name="DRIVER_AGE")
    @NotNull
	private Integer driverAge;
	
	@Column(name="DRIVER_EMAIL")
    @NotNull
	private String driverEmail;
		
	@Column(name="DRIVER_BLOODGRP")
    @NotNull
	private String driverBloodGrp;
	
	@Column(name="DRIVER_LICENSE_NO")
    @NotNull
	private String driverLicenseNo;
	
	@Column(name="DRIVER_LICENSE_ISSUE_DATE")
    @NotNull
	private String driverLicenseIssueDate;
	
	@Column(name="DRIVER_LICENSE_EXP_DATE")
    @NotNull
	private String driverLicenseExpDate;
	
	@Column(name="DRIVER_LICENSE_STATUS")
    @NotNull
	private String driverLicenseStatus;
	
	@Column(name="DRIVER_LICENSE_TEST_STATUS")
    @NotNull
	private String driverLicenseTestStatus;
	
	@Column(name="DRIVER_LICENSE_TYPE")
    @NotNull
	private String driverLicenseType;
	
	@Column(name="DRIVER_ADDRESS_LINE1")
    @NotNull
	private String driverAddressLine1;
	
	@Column(name="DRIVER_ADDRESS_LINE2")
	private String driverAddressLine2;
	
	@Column(name="DRIVER_STATE")
    @NotNull
	private String driverState;
	
	@Column(name="DRIVER_COUNTRY")
    @NotNull
	private String driverCountry;
	
	@Column(name="DRIVER_POSTALCODE")
    @NotNull
	private String driverPostalCode;
	
	@Column(name="DRIVER_DOB")
    @NotNull
	private String driverDob;
	
	@Column(name="DRIVER_LICENSE_TRILLIUM_NO")
    @NotNull
	private String driverLicenseTrilliumNo;	
	
	@Column(name="DRIVER_HEALTH_CARD_EXP_DATE")
    @NotNull
	private String driverHealthCardExpDate;		
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDriverFName() {
		return driverFName;
	}

	public void setDriverFName(String driverFName) {
		this.driverFName = driverFName;
	}

	public String getDriverLName() {
		return driverLName;
	}

	public void setDriverLName(String driverLName) {
		this.driverLName = driverLName;
	}

	public Integer getDriverAge() {
		return driverAge;
	}
	
	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}

	public void setDriverAge(Integer driverAge) {
		this.driverAge = driverAge;
	}

	public String getDriverBloodGrp() {
		return driverBloodGrp;
	}

	public void setDriverBloodGrp(String driverBloodGrp) {
		this.driverBloodGrp = driverBloodGrp;
	}

	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}

	public String getDriverLicenseIssueDate() {
		return driverLicenseIssueDate;
	}

	public void setDriverLicenseIssueDate(String driverLicenseIssueDate) {
		this.driverLicenseIssueDate = driverLicenseIssueDate;
	}

	public String getDriverLicenseExpDate() {
		return driverLicenseExpDate;
	}

	public void setDriverLicenseExpDate(String driverLicenseExpDate) {
		this.driverLicenseExpDate = driverLicenseExpDate;
	}

	public String getDriverLicenseStatus() {
		return driverLicenseStatus;
	}

	public void setDriverLicenseStatus(String driverLicenseStatus) {
		this.driverLicenseStatus = driverLicenseStatus;
	}

	public String getDriverLicenseTestStatus() {
		return driverLicenseTestStatus;
	}

	public void setDriverLicenseTestStatus(String driverLicenseTestStatus) {
		this.driverLicenseTestStatus = driverLicenseTestStatus;
	}

	public String getDriverLicenseType() {
		return driverLicenseType;
	}

	public void setDriverLicenseType(String driverLicenseType) {
		this.driverLicenseType = driverLicenseType;
	}

	public String getDriverAddressLine1() {
		return driverAddressLine1;
	}

	public void setDriverAddressLine1(String driverAddressLine1) {
		this.driverAddressLine1 = driverAddressLine1;
	}

	public String getDriverAddressLine2() {
		return driverAddressLine2;
	}

	public void setDriverAddressLine2(String driverAddressLine2) {
		this.driverAddressLine2 = driverAddressLine2;
	}

	public String getDriverState() {
		return driverState;
	}

	public void setDriverState(String driverState) {
		this.driverState = driverState;
	}

	public String getDriverCountry() {
		return driverCountry;
	}

	public void setDriverCountry(String driverCountry) {
		this.driverCountry = driverCountry;
	}

	public String getDriverPostalCode() {
		return driverPostalCode;
	}

	public void setDriverPostalCode(String driverPostalCode) {
		this.driverPostalCode = driverPostalCode;
	}

	public String getDriverDob() {
		return driverDob;
	}

	public void setDriverDob(String driverDob) {
		this.driverDob = driverDob;
	}

	public String getDriverLicenseTrilliumNo() {
		return driverLicenseTrilliumNo;
	}

	public void setDriverLicenseTrilliumNo(String driverLicenseTrilliumNo) {
		this.driverLicenseTrilliumNo = driverLicenseTrilliumNo;
	}

	public String getDriverHealthCardExpDate() {
		return driverHealthCardExpDate;
	}

	public void setDriverHealthCardExpDate(String driverHealthCardExpDate) {
		this.driverHealthCardExpDate = driverHealthCardExpDate;
	}
	
}
