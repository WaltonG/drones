package com.musala.drones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musala.drones.models.Medication;

public interface MedicationRepository extends JpaRepository<Medication, String> {
}
