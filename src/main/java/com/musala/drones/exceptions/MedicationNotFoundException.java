package com.musala.drones.exceptions;


public class MedicationNotFoundException extends APIException {
	
	public MedicationNotFoundException(String message) {
		super(message);
	}
	
	public MedicationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MedicationNotFoundException(Throwable cause) {
		super(cause);
	}
}
