package com.poc.beans;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class EligibilityCheckRequestBean {
	

	@NotNull(message="DRIVER EMAIL CANNOT BE NULL")
	@NotBlank(message="DRIVER EMAIL CANNOT BE BLANK")
	@ApiModelProperty(example="DRIVER_EMAIL")
	private String driverEmail;
	
	@NotNull(message="DRIVER MUSCLE PAIN STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER MUSCLE PAIN STATUS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String musclePain;
	
	@NotNull(message="DRIVER POOR DRIVING HABITS STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER POOR DRIVING HABITS STATUS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String drivingHabitsStatus;
	
	@NotNull(message="DRIVER CARDIAC STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER CARDIAC STATUS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String cardiacStatus;
	
	@NotNull(message="DRIVER BREATH SHORTNESS STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER BREATH SHORTNESS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String breathStatus;
	
	@NotNull(message="DRIVER EYE VISION STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER EYE VISION STATUS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String eyeVisionStatus;
	
	@NotNull(message="DRIVER ACCIDENT STATUS CANNOT BE NULL")
	@NotBlank(message="DRIVER ACCIDENT STATUS CANNOT BE BLANK")
	@ApiModelProperty(example="YES/NO")
	private String accidentStatus;
	
	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}

	public String getMusclePain() {
		return musclePain;
	}

	public void setMusclePain(String musclePain) {
		this.musclePain = musclePain;
	}

	public String getDrivingHabitsStatus() {
		return drivingHabitsStatus;
	}

	public void setDrivingHabitsStatus(String drivingHabitsStatus) {
		this.drivingHabitsStatus = drivingHabitsStatus;
	}

	public String getCardiacStatus() {
		return cardiacStatus;
	}

	public void setCardiacStatus(String cardiacStatus) {
		this.cardiacStatus = cardiacStatus;
	}

	public String getBreathStatus() {
		return breathStatus;
	}

	public void setBreathStatus(String breathStatus) {
		this.breathStatus = breathStatus;
	}

	public String getEyeVisionStatus() {
		return eyeVisionStatus;
	}

	public void setEyeVisionStatus(String eyeVisionStatus) {
		this.eyeVisionStatus = eyeVisionStatus;
	}

	public String getAccidentStatus() {
		return accidentStatus;
	}

	public void setAccidentStatus(String accidentStatus) {
		this.accidentStatus = accidentStatus;
	}

}
