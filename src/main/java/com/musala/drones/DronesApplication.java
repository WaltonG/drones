package com.musala.drones;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import com.musala.drones.models.ModelType;
import com.musala.drones.models.Status;
import com.musala.drones.repositories.DroneRepository;
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
	
	 @Bean
	    CommandLineRunner init(DroneRepository repository) {
	        return args -> {

				List<Medication> droneMedications = Arrays.asList(new Medication("Zitromax", 30, "ZITROMAX_500"),
				    new Medication("Lipitor", 30.7, "LIPTOR_100"), new Medication("Paracetamol", 10.5, "PARACETAMOL_500")
	            );

				Drone drone = new Drone();
				drone.setBatteryPercentage(100);
				drone.setWeightLimit(100);
				drone.setModel(ModelType.Cruiserweight);
				drone.setState(Status.IDLE);
				droneMedications.forEach(drone::addMedication);
				drone.setSerialNumber("cruiserWeight1");
				repository.save(drone);

			};
	    }
}
