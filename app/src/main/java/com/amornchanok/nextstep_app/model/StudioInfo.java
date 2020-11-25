package com.amornchanok.nextstep_app.model;

import java.util.ArrayList;

public class StudioInfo {
    private ArrayList <Convenient> convenients;
    private TimeService timeService;

    public ArrayList<Convenient> getConvenients() {
        return convenients;
    }

    public void setConvenients(ArrayList<Convenient> convenients) {
        this.convenients = convenients;
    }

    public TimeService getTimeService() {
        return timeService;
    }

    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

}
