package com.musala.drones.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "drone")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drone {
	
	@Id
	@Column(name = "serial_number", length = 100, unique = true)
	private String serialNumber;
	
	@Column(name = "model")
	private ModelType model;
	
	@Column(name = "weight_limit")
	private double weightLimit;
	
	@Column(name = "battery_percentage")
	private int batteryPercentage;
	
	@Column(name = "status")
	private Status state;
	
	@OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Medication> medications;
	
	public Drone() {
		
	}
	
	public Drone(String serialNumber, ModelType model, double weightLimit, int batteryPercentage, Status state) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryPercentage = batteryPercentage;
		this.state = state;
		this.medications = new ArrayList<>();
	}
	
	public Drone(String serialNumber, ModelType model, double weightLimit, int batteryPercentage, Status state,
	    List<Medication> medications) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryPercentage = batteryPercentage;
		this.state = state;
		this.medications = medications != null ? medications : new ArrayList<>();
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	public double getWeightLimit() {
		return weightLimit;
	}
	
	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}
	
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}
	
	
	public List<Medication> getMedications() {
		return medications;
	}
	
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
	
	public ModelType getModel() {
		return model;
	}
	
	public void setModel(ModelType model) {
		this.model = model;
	}

	public Status getState() {
		return state;
	}
	
	public void setState(Status state) {
		this.state = state;
	}
	
}

