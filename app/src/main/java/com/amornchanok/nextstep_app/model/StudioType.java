package com.amornchanok.nextstep_app.model;

public class StudioType {
    private String name;
    private String tag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "StudioType{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
