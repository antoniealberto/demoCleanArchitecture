package edu.demo.cleanarchitecture.smarthouse.framework.api.adapters.config;

import edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.config.ConfigurationServicePort;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService implements ConfigurationServicePort {
    @Override
    public <T> T getPropertyValue(String configurationKey, Class<T> type) {
        return null;
    }
}
