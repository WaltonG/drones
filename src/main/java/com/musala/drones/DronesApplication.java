package com.musala.drones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

import com.musala.drones.services.BatteryLevelAuditService;
import com.musala.drones.services.DroneService;
import com.musala.drones.util.BatteryLevelTask;


@SpringBootApplication
public class DronesApplication {
	
	@Autowired
	private DroneService droneService;
	
	@Autowired
	private BatteryLevelAuditService auditService;

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}

	@Bean
	public CommandLineRunner schedulingRunner(TaskExecutor executor) {
		final BatteryLevelTask task = new BatteryLevelTask(droneService, auditService);
		return args -> executor.execute(task.startTaskTimer());
	}
}
