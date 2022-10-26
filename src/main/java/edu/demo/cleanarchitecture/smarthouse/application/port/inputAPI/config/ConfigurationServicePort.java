package edu.demo.cleanarchitecture.smarthouse.application.port.inputAPI.config;

public interface ConfigurationServicePort {

    public <T> T getPropertyValue(String configurationKey, Class<T> type);
}
