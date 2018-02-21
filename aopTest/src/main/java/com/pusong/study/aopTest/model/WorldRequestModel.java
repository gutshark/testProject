package com.pusong.study.aopTest.model;

public class WorldRequestModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WorldRequestModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
