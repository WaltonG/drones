package com.musala.drones.exceptions;


public class DroneRegistrationException extends APIException {
	
	public DroneRegistrationException(String message) {
		super(message);
	}
	
	public DroneRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DroneRegistrationException(Throwable cause) {
		super(cause);
	}
}
