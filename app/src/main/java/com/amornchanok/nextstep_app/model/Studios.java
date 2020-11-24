package com.amornchanok.nextstep_app.model;

import java.util.ArrayList;

public class Studios {
    private String id;
    private StudioInfo info;
    private StudioPicture pic;
    private StudioType type;
    private ArrayList <String> journey;
    private StudioLocation location;
    private Integer price;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudioInfo getInfo() {
        return info;
    }

    public void setInfo(StudioInfo info) {
        this.info = info;
    }

    public StudioPicture getPic() {
        return pic;
    }

    public void setPic(StudioPicture pic) {
        this.pic = pic;
    }

    public StudioType getType() {
        return type;
    }

    public void setType(StudioType type) {
        this.type = type;
    }

    public ArrayList<String> getJourney() {
        return journey;
    }

    public void setJourney(ArrayList<String> journey) {
        this.journey = journey;
    }

    public StudioLocation getLocation() {
        return location;
    }

    public void setLocation(StudioLocation location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}