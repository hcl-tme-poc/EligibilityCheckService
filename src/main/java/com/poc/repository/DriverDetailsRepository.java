package com.poc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.model.DriverDetails;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Serializable>{
	
	public DriverDetails findByDriverEmail(String _driverEmail);

}
