package com.musala.drones.models.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class MedicationImageDTO {
	
	MultipartFile image;
	
	String medicationCode;
	
	public MedicationImageDTO(MultipartFile image, String medicationCode) {
	
		this.image = image;
		this.medicationCode = medicationCode;
	}
	
	public MultipartFile getImage() {
		return image;
	}
	
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public String getMedicationCode() {
		return medicationCode;
	}
	
	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}
	
}

