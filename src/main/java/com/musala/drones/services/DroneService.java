package com.musala.drones.services;

import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;

public interface DroneService {
	
	Drone registerDrone(Drone drone) throws DroneRegistrationException;
	
}
