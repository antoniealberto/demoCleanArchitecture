package edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.instrumentation;

import edu.demo.cleanarchitecture.smarthouse.domain.model.Device;

import java.util.Set;

public interface Dashboard {
    Set<Device> getActiveDevices();
}
