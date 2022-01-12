package com.musala.drones.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "medication")
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class Medication extends DatabaseAudit {
	
	@Id
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "weight")
	private double weight;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "drone")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Drone drone;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "image")
	private byte[] image;
	
	public Medication() {
		
	}
	
	public Medication(String name, double weight, String code) {
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public Medication(String name, double weight, String code, byte[] image) {
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.image = image;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Drone getDrone() {
		return drone;
	}
	
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
}
