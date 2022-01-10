package com.musala.drones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musala.drones.exceptions.DroneNotFoundException;
import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.dto.MedicineLoadDTO;
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
	public ResponseEntity<Drone> saveDrone(@RequestBody Drone drone) throws DroneRegistrationException {
		droneService.registerDrone(drone);
		return new ResponseEntity<Drone>(drone, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loaddrone", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> loadDroneWithMedications(@RequestBody MedicineLoadDTO dto) throws DroneNotFoundException {
		return new ResponseEntity<String>(droneService.loadDroneWithMedications(dto), HttpStatus.OK);
	}
}