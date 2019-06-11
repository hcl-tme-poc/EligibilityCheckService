package com.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DRIVER_REGISTRATION")
public class DriverRegistration {
	

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	 
    @Column(name="DRIVER_REG_ID")
    private Long id;
	
	@Column(name="DRIVER_EMAIL")
    @NotNull
	private String driverEmail;
	
	@Column(name="DRIVER_CONTACT_NO")
	private String driverContactNo;
	
	@Column(name="DRIVER_STATUS")
    @NotNull
	private String driverStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}

	public String getDriverContactNo() {
		return driverContactNo;
	}

	public void setDriverContactNo(String driverContactNo) {
		this.driverContactNo = driverContactNo;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
		

}
