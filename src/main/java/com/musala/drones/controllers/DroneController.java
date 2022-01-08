package com.musala.drones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musala.drones.models.Drone;
import com.musala.drones.services.DroneService;

@RestController
@RequestMapping("/api/v1/drone")
public class DroneController {
	
	private final DroneService droneService;
	
	@Autowired
	public DroneController(DroneService droneService) {
		this.droneService = droneService;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Drone saveDrone(@RequestBody Drone drone) {
		return droneService.registerDrone(drone);
	}
}
