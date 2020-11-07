package com.amornchanok.nextstep_app;

public class Studios {
    private String id;
    private String name;
    private String location;

    public Studios(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.name = location;
    }

    public Studios(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Studios() {
    }

    public String toString() {
        return this.id + " " + this.name + " " + location;
    }
}