package com.amornchanok.nextstep_app.model;

public class Convenient {
    private String name;
    private String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Convenient{" +
                "name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
