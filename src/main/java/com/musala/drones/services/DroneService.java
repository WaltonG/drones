package com.musala.drones.services;

import java.util.List;

import com.musala.drones.exceptions.DroneNotFoundException;
import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import com.musala.drones.models.dto.MedicineLoadDTO;

public interface DroneService {
	
	Drone registerDrone(Drone drone) throws DroneRegistrationException;
	
	String loadDroneWithMedications(MedicineLoadDTO dto) throws DroneNotFoundException;
	
	List<Medication> checkMedicationItemsForDrone(String serialNumber) throws DroneNotFoundException;
	
}
