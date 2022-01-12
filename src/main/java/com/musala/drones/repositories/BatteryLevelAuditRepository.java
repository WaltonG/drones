package com.musala.drones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.drones.models.BatteryLevelAudit;

@Repository
public interface BatteryLevelAuditRepository extends JpaRepository<BatteryLevelAudit, Long> {
	
}
