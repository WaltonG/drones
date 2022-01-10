package com.musala.drones.exceptions;


public class DroneNotFoundException extends APIException {
	
	public DroneNotFoundException(String message) {
		super(message);
	}
	
	public DroneNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DroneNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
