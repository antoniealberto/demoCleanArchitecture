package edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.logging;

import edu.demo.cleanarchitecture.smarthouse.application.port.outputSPI.logging.LoggingServicePort;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements LoggingServicePort {

    @Override
    public void log(String message) {

    }
}
