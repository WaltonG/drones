package com.musala.drones.models;

public enum Status {
	
	IDLE("Idle"),
	LOADING("Loading"),
	LOADED("Loaded"),
	DELIVERING("Delivering"),
	DELIVERED("Delivered"),
	RETURNING("Returning");
	
	private final String status;
	
	Status(String status) {
		this.status = status;
	}
	
	public String getName() {
		return status;
	}

}
