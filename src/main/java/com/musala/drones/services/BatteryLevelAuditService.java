package com.musala.drones.services;

import java.util.List;

import com.musala.drones.models.BatteryLevelAudit;

public interface BatteryLevelAuditService {
	
	BatteryLevelAudit addAuditLog(BatteryLevelAudit audit);
	
	List<BatteryLevelAudit> listAuditLogs();
}
