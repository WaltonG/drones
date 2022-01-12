package com.musala.drones.services;

import com.musala.drones.exceptions.AddMedicationException;
import com.musala.drones.exceptions.MedicationNotFoundException;
import com.musala.drones.models.Medication;
import com.musala.drones.models.dto.MedicationImageDTO;

public interface MedicationService {
	
	Medication addImage(MedicationImageDTO dto) throws AddMedicationException, MedicationNotFoundException;
}
