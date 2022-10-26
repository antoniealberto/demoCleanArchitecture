package edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.repository;

import edu.demo.cleanarchitecture.smarthouse.domain.model.Device;

import java.util.Set;

public interface DeviceRepositoryQueryManager {
    Set<Device> getDevices();
}
