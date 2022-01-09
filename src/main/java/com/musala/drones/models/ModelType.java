package com.musala.drones.models;

public enum ModelType {
	
	Lightweight("Lightweight"),
	Middleweight("Middleweight"),
	Cruiserweight("Cruiserweight"),
	Heavyweight("Heavyweight");
	
	private final String modelType;
	
	ModelType(String modelType) {
		this.modelType = modelType;
	}
	
	public String getmodelType() {
		return modelType;
	}
	
}
