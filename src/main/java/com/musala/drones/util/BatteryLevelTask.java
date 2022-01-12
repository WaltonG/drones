package com.musala.drones.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.musala.drones.models.BatteryLevelAudit;
import com.musala.drones.services.BatteryLevelAuditService;
import com.musala.drones.services.DroneService;

public class BatteryLevelTask {
	
	private final DroneService droneService;
	
	private final BatteryLevelAuditService batteryLevelAuditService;
	
	@Autowired
	public BatteryLevelTask(DroneService droneService, BatteryLevelAuditService batteryLevelAuditService) {
		
		this.droneService = droneService;
		this.batteryLevelAuditService = batteryLevelAuditService;
	}
	
	@Async
	public Runnable startTaskTimer() {
		final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		final Runnable task = () -> droneService.getAllDrones().thenAccept(
		    list -> list.stream().map(l -> new BatteryLevelAudit(l.getSerialNumber(), l.getBatteryPercentage()))
		            .forEach(batteryLevelAuditService::addAuditLog));
		executor.scheduleAtFixedRate(task, 0, 60, TimeUnit.SECONDS);
		return task;
	}
}
