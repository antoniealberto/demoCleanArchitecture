package edu.demo.cleanarchitecture.smarthouse.framework.api.adapters.instrumentation.web.controller;

import edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.instrumentation.Dashboard;
import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.logging.LoggingServicePort;
import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.repository.DeviceRepositoryQueryManager;
import edu.demo.cleanarchitecture.smarthouse.domain.model.Device;
import edu.demo.cleanarchitecture.smarthouse.framework.api.adapters.instrumentation.web.model.DeviceForm;
import edu.demo.cleanarchitecture.smarthouse.framework.api.adapters.instrumentation.web.view.HomeDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class DashboardController {

    //private final Dashboard dashboardService;
    private final LoggingServicePort loggingService;

    //private final DeviceRepositorySaveManager deviceRepositorySaveManager;
    private final DeviceRepositoryQueryManager deviceRepositoryQueryManager;

    @Autowired
    public DashboardController(DeviceRepositoryQueryManager deviceRepositoryQueryManager,/*Dashboard dashboardService, /*DeviceRepositorySaveManager deviceRepositorySaveManager,*/ LoggingServicePort loggingService){
       //this.dashboardService = dashboardService;
       // this.deviceRepositorySaveManager = deviceRepositorySaveManager;
        this.deviceRepositoryQueryManager = deviceRepositoryQueryManager;
        this.loggingService = loggingService;
    }

    public Set<String> getActiveDevices() {
        Set<String> activeDevicesViewAsJsons = new TreeSet<>();
        Set<Device> activeDevices = this.deviceRepositoryQueryManager.getDevices();
        //Set<Device> activeDevices = this.dashboardService.getActiveDevices();
        Set<HomeDevice> activeDevicesView = getActiveDevicesView(activeDevices);
        return activeDevicesViewAsJsons;
    }

    public String addDevice(DeviceForm deviceForm){
        return null;
    }

    private Set<HomeDevice> getActiveDevicesView(Set<Device> activeDevices) {
        return Collections.emptySet();
    }
}
