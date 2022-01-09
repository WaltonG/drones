package com.musala.drones.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.drones.exceptions.DroneRegistrationException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import com.musala.drones.models.Status;
import com.musala.drones.models.dto.MedicineLoadDTO;
import com.musala.drones.repositories.DroneRepository;
import com.musala.drones.services.DroneService;
import com.musala.drones.util.Validator;

@Service
public class DroneServiceImpl implements DroneService {
	
	private final DroneRepository repository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	@Override
	public String loadDroneWithMedications(MedicineLoadDTO dto) {
		
		if (dto.getMedications().isEmpty())
			return "No medications to be loaded ";
		
		if (dto.getSerialNumber() == null || dto.getMedications() == null)
			return "Wrong details provided";
		
		if (dto.getSerialNumber().length() == 0)
			return "Invalid serial number!";
		
		Optional<Drone> optionalDrone = repository.findById(dto.getSerialNumber());
		Drone drone = optionalDrone.orElseGet(null);
		
		if (drone == null)
			return "No drone found for the provided serial number";
		
		if (drone.getBatteryPercentage() < 25
		        || (!drone.getState().equals(Status.IDLE) && !drone.getState().equals(Status.LOADING)))
			return "Drone not available for loading.";
		
		List<Medication> filteredMedications = dto.getMedications().stream().filter(m -> {
			boolean valid = Validator.isValidMedicationName(m.getName()) && Validator.isValidMedicationCode(m.getCode());
			if (!valid)
				logger.info("Filtered out because of incorrect name {}", m.getName() + "or code {}", m.getCode());
			return valid;
		}).collect(Collectors.toList());
		
		if (filteredMedications.isEmpty())
			return "Provided medications have incorrect name or code";
		
		drone.setState(Status.LOADING);
		repository.save(drone);
		
		final double totalMedicationsWeight = filteredMedications.stream().mapToDouble(Medication::getWeight).sum();
		final List<Medication> availableLoad = new ArrayList<>();
		if (drone.getMedications().isEmpty() && drone.getWeightLimit() >= totalMedicationsWeight) {
            saveLoadedMedications(drone, filteredMedications);
			return "Medications loaded";
		}else {
            double availableSpace = drone.getWeightLimit() - drone.getMedications().stream().mapToDouble(Medication::getWeight).sum();
            if (availableSpace > totalMedicationsWeight) {
                saveLoadedMedications(drone, filteredMedications);
				return "Medications loaded";
			} else {
				for (Medication m : filteredMedications) {
					if (m.getWeight() <= availableSpace) {
						availableLoad.add(m);
						availableSpace -= m.getWeight();
					} else {
						logger.info("Maximum weight reached");
					}
				}
			}
		}
		
		if (!availableLoad.isEmpty()) {
			saveLoadedMedications(drone, availableLoad);
			return "Medications loaded";
		}
		return "Weight exceeded";
	}
	
	private void saveLoadedMedications(Drone drone, List<Medication> list) {
		list.forEach(drone::addMedication);
		repository.save(drone);
	}
}
