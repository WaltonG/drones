package com.musala.drones.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Model {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "model_type")
	private ModelType modelType;
	
	public ModelType getModelType() {
		return modelType;
	}
	
	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}
	
}
