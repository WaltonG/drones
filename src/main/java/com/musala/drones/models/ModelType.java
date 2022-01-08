package com.musala.drones.models;

public enum ModelType {
	
	Lightweight("Lightweight"),
	Middleweight("Middleweight"),
	Cruiserweight("Cruiserweight"),
	Heavyweight("Heavyweight");
	
	private final String name;
	
	ModelType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return this.toString();
	}
}
