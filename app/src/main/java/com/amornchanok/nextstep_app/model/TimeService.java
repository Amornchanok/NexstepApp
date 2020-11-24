package com.amornchanok.nextstep_app.model;

public class TimeService {
    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    private String on;
    private String close;

    @Override
    public String toString() {
        return "TimeService{" +
                "on='" + on + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
