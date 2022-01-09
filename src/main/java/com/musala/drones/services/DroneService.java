package com.musala.drones.services;

import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.dto.MedicineLoadDTO;

public interface DroneService {
	
	Drone registerDrone(Drone drone) throws DroneRegistrationException;
	
	String loadDroneWithMedications(MedicineLoadDTO dto);
	
}
