package edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository;

import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.repository.DeviceRepositoryQueryManager;
import edu.demo.cleanarchitecture.smarthouse.domain.model.Device;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class DeviceRepositoryDbQueryService implements DeviceRepositoryQueryManager {
    @Override
    public Set<Device> getDevices() {
        return Collections.emptySet();
    }
}
