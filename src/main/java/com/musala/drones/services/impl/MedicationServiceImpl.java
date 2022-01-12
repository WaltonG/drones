package com.musala.drones.services.impl;


import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.drones.exceptions.AddMedicationException;
import com.musala.drones.exceptions.MedicationNotFoundException;
import com.musala.drones.models.Medication;
import com.musala.drones.models.dto.MedicationImageDTO;
import com.musala.drones.repositories.MedicationRepository;
import com.musala.drones.services.MedicationService;
import com.musala.drones.util.ImageHandler;
import com.musala.drones.util.Validator;

@Service
public class MedicationServiceImpl implements MedicationService {
	
	private final MedicationRepository repository;
	
	@Autowired
    public MedicationServiceImpl(MedicationRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Medication addImage(MedicationImageDTO dto) throws AddMedicationException, MedicationNotFoundException {
		
		if (dto == null)
			throw new NullPointerException();
		
		if (!Validator.isValidMedicationCode(dto.getMedicationCode()))
			throw new AddMedicationException("Invalid medication code");
		
		if (StringUtils.isBlank(dto.getMedicationCode()))
			throw new AddMedicationException("Null reference provided");
		
		Optional<Medication> optionalMedication = repository.findById(dto.getMedicationCode());
		
		if (!optionalMedication.isPresent())
			throw new MedicationNotFoundException("Medication not found");
		
		Medication medication = optionalMedication.get();
		
		try {
			if (dto.getImage() != null) {
				byte[] image = ImageHandler.compressBytes(dto.getImage().getBytes());
				medication.setImage(image);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		
		return repository.save(medication);
	}
	
}
