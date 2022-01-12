package com.musala.drones.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.drones.models.BatteryLevelAudit;
import com.musala.drones.repositories.BatteryLevelAuditRepository;
import com.musala.drones.services.BatteryLevelAuditService;

@Service
public class BatteryLevelAuditServiceImpl implements BatteryLevelAuditService {
	
	private final BatteryLevelAuditRepository auditRepository;
	
	@Autowired
	public BatteryLevelAuditServiceImpl(BatteryLevelAuditRepository auditRepository) {
		this.auditRepository = auditRepository;
	}
	@Override
	public BatteryLevelAudit addAuditLog(BatteryLevelAudit audit) {
		return auditRepository.save(audit);
	}

	@Override
	public List<BatteryLevelAudit> listAuditLogs() {
		return auditRepository.findAll();
	}
	
}
