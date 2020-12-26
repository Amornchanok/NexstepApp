package com.amornchanok.nextstep_app.studioProfile;

import com.amornchanok.nextstep_app.model.Studios;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

interface StudioProfile {

    interface View{
        void onStudiosSuccess(Studios studio);
    }

    interface Presenter{
        void getStudio(String id);
    }
}
