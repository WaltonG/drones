package com.musala.drones.exceptions;


public class AddMedicationException extends APIException {
	
	public AddMedicationException(String message) {
		super(message);
	}
	
	public AddMedicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AddMedicationException(Throwable cause) {
		super(cause);
	}
}
