package com.musala.drones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.musala.drones.exceptions.APIException;
import com.musala.drones.models.Medication;
import com.musala.drones.models.dto.MedicationImageDTO;
import com.musala.drones.services.MedicationService;


@RestController
@RequestMapping("/api/v1/medication")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = "multipart/form-data")
	public ResponseEntity<Medication> addImage(@RequestParam("code") String code, @RequestParam("image") MultipartFile image)
	        throws APIException {
		return new ResponseEntity<Medication>(medicationService.addImage(new MedicationImageDTO(image, code)),
		        HttpStatus.OK);
    }
	
}
