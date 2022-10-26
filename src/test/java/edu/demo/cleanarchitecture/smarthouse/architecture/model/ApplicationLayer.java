package edu.demo.cleanarchitecture.smarthouse.architecture.model;

public enum ApplicationLayer {
    DOMAIN("DOMAIN"),
    APPLICATION("APPLICATION"),
    ADAPTER("ADAPTER"),
    CONTROLLER("Controller");


    private String name;

    ApplicationLayer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
