package com.musala.drones.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musala.drones.models.Medication;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class MedicineLoadDTO {
	
	String serialNumber;
	
	List<Medication> medications;
	
	public MedicineLoadDTO(String serialNumber, List<Medication> medications) {
		this.serialNumber = serialNumber;
		this.medications = medications;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public List<Medication> getMedications() {
		return medications;
	}
	
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
}
