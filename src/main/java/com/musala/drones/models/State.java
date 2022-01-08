package com.musala.drones.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class State {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
