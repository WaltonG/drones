package com.musala.drones.models;

public enum Status {
	
	IDLE("Idle"),
	LOADING("Loading"),
	LOADED("Loaded"),
	DELIVERING("Delivering"),
	DELIVERED("Delivered"),
	RETURNING("Returning");
	
	private final String name;
	
	Status(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return this.toString();
	}
}
