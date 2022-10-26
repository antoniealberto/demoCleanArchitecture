package edu.demo.cleanarchitecture.smarthouse.domain.model;

import java.util.Objects;

public class Device implements DomainEntity {

    private final HouseEntity houseEntity;

    public Device(Integer id, String name, String description) {
        this.houseEntity = new HouseEntity(id);
        this.houseEntity.setName(name);
        this.houseEntity.setDescription(description);
    }

    @Override
    public Integer getId() {
        return this.houseEntity.getId();
    }

    @Override
    public String getName() {
        return this.houseEntity.getName();
    }

    @Override
    public String getDescription() {
        return this.houseEntity.getDescription();
    }

    void setName(String name) {
       this.houseEntity.setName(name);
    }

    void setDescription(String description) {
        this.houseEntity.setDescription(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return houseEntity.equals(device.houseEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseEntity);
    }

    @Override
    public String toString() {
        return "Device{" +
                "houseEntity=" + houseEntity +
                '}';
    }
}
