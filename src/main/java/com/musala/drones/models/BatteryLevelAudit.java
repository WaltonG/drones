package com.musala.drones.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BatteryLevelAudit extends DatabaseAudit {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "drone")
	private String serialNumber;
	
	@Column(name = "battery_percentage")
	private int batteryPercentage;


	public BatteryLevelAudit(String serialNumber, int batteryPercentage) {
		this.serialNumber = serialNumber;
		this.batteryPercentage = batteryPercentage;
		this.createdAt = new Date();
        this.updatedAt = new Date();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}
	
}
