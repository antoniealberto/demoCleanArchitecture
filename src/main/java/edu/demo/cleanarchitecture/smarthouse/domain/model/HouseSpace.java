package edu.demo.cleanarchitecture.smarthouse.domain.model;

public class HouseSpace implements DomainEntity {

    private final HouseEntity houseEntity;

    public HouseSpace(Integer id, String name, String description) {
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
}