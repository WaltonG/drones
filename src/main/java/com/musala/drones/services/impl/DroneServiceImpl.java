package com.musala.drones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Drone registerDrone(Drone drone) {
		
		if (drone == null)
			throw new NullPointerException("Null drone reference");
		
		return repository.save(drone);
	}
	
}
