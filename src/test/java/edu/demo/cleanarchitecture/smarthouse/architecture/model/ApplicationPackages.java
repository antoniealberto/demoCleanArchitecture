package edu.demo.cleanarchitecture.smarthouse.architecture.model;

public enum ApplicationPackages {
    API (""),
    CONTROLLER("..web.controller..");



    private String name;

    ApplicationPackages(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
