package com.amornchanok.nextstep_app;

public class Studios {
    private String id;
    private String stdname;
    private String location;
    private String score;

    public Studios(String id, String stdname, String location ,String score) {
        this.id = id;
        this.stdname = stdname;
        this.location = location;
        this.score = score;
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

    public void setStdname(String stdname) { this.stdname = stdname; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



    public Studios() {
    }

    public String toString() {
        return stdname + " " + location;
    }


}