package com.musala.drones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.drones.models.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {
}
