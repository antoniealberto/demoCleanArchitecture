package edu.demo.cleanarchitecture.smarthouse.domain.model;

import java.util.Objects;

public class Group implements DomainEntity {

    private final HouseEntity houseEntity;

    public Group(Integer id, String name, String description) {
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
        Group group = (Group) o;
        return houseEntity.equals(group.houseEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseEntity);
    }
}

