package com.musala.drones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musala.drones.exceptions.DroneNotFoundException;
import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
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
	
	@RequestMapping(value = "/checkmedications/{serialNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Medication>> checkMedicationItemsForDrone(@PathVariable(value = "serialNumber") String serialNumber)
	        throws DroneNotFoundException {
		return new ResponseEntity<List<Medication>>(droneService.checkMedicationItemsForDrone(serialNumber), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/dronesavailableforloading", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Drone>> checkAvailableDronesForLoading() {
		return new ResponseEntity<List<Drone>>(droneService.checkAvailableDronesForLoading(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/checkbatterylevel/{serialNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Integer> checkBatteryLevelForDrone(@PathVariable(value = "serialNumber") String serialNumber)
	        throws DroneNotFoundException {
		return new ResponseEntity<Integer>(droneService.checkBatteryLevelForDrone(serialNumber), HttpStatus.OK);
		
	}
}
