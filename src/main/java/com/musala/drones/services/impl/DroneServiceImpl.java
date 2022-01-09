package com.musala.drones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.repositories.DroneRepository;
import com.musala.drones.services.DroneService;

@Service
public class DroneServiceImpl implements DroneService {
	
	private final DroneRepository repository;
	
	@Autowired
	public DroneServiceImpl(DroneRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Drone registerDrone(Drone drone) throws DroneRegistrationException {
		
		if (drone == null)
			throw new DroneRegistrationException("Null drone reference");
		
		if (drone.getSerialNumber().length() > 100)
			throw new DroneRegistrationException("Serial number cannot exceed 100 characters");
		
		return repository.save(drone);
	}
	
}
