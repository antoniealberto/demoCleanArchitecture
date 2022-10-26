package edu.demo.cleanarchitecture.smarthouse.domain.service;

import edu.demo.cleanarchitecture.smarthouse.domain.model.House;

public interface HouseManagementService {
    House setupHouse(String name, String description);
    boolean removeHouse(House house);
}
