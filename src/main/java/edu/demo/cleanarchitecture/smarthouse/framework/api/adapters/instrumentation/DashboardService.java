package edu.demo.cleanarchitecture.smarthouse.framework.api.adapters.instrumentation;

import edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.config.ConfigurationServicePort;
import edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.instrumentation.Dashboard;
import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.logging.LoggingServicePort;
import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.repository.DeviceRepositoryQueryManager;
import edu.demo.cleanarchitecture.smarthouse.domain.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class DashboardService implements Dashboard {
    private final ConfigurationServicePort configurationService;
    private final LoggingServicePort loggingService;

    private final DeviceRepositoryQueryManager deviceRepositoryQueryManager;

    @Autowired
    public DashboardService(DeviceRepositoryQueryManager deviceRepositoryQueryManager, ConfigurationServicePort configurationService, LoggingServicePort loggingService){
        this.configurationService = configurationService;
        this.loggingService = loggingService;
        this.deviceRepositoryQueryManager = deviceRepositoryQueryManager;
    }
    @Override
    public Set<Device> getActiveDevices() {
        String aProperty = this.configurationService.getPropertyValue("aKey", String.class);
        Set<Device> activeDevices = this.deviceRepositoryQueryManager.getDevices();
        return activeDevices;
    }
}
