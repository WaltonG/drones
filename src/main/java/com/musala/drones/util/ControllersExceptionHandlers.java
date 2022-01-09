package com.musala.drones.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.musala.drones.exceptions.DroneRegistrationException;


@ControllerAdvice
public class ControllersExceptionHandlers extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public static ResponseEntity<Object> handle(Throwable t) {
		if (t.getCause() instanceof DroneRegistrationException)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t.getCause().getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t.getMessage());
		
	}
}
