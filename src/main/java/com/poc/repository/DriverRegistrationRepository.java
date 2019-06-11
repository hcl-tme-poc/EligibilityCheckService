package com.poc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.model.DriverRegistration;

public interface DriverRegistrationRepository extends JpaRepository<DriverRegistration, Serializable>{
	
	public DriverRegistration findByDriverEmail(String _driverEmail);

}
