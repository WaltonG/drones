package com.musala.drones.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "drone")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drone {
	
	@Id
	@Column(name = "serial_number", length = 100, unique = true)
	private String serialNumber;
	
	@Embedded
	private Model model;
	
	@Column(name = "weight_limit")
	private double weightLimit;
	
	@Column(name = "battery_percentage")
	private int batteryPercentage;
	
	@Embedded
	private State state;
	
	@OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Medication> medications;
	
	public Drone() {
		
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
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
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public List<Medication> getMedications() {
		return medications;
	}
	
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
	
	public ModelType getModelType() {
		return model.getModelType();
	}
	
	public void setModelType(ModelType modelType) {
		this.model.setModelType(modelType);
	}
	
	public void setModelType(String type) {
		this.model.setModelType(StringUtils.isBlank(type) ? null : ModelType.valueOf(type));
	}
	
	public Status getStatus() {
		return state.getStatus();
	}
	
	public void setStatus(Status status) {
		this.state.setStatus(status);
	}
	
	public void setStatus(String status) {
		this.state.setStatus(StringUtils.isBlank(status) ? null : Status.valueOf(status));
	}
}
