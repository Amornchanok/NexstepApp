package com.amornchanok.nextstep_app;

public class Studios {
    private String id;
    private String stdname;
    private String location;

    public Studios(String id, String stdname, String location) {
        this.id = id;
        this.stdname = stdname;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Studios() {
    }

    public String toString() {
        return stdname + " " + location;
    }
}