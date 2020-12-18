package com.amornchanok.nextstep_app.searchStudio;

import com.amornchanok.nextstep_app.model.Studios;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

interface SearchRoom {

    interface View{
        void onStudiosSuccess(ArrayList<Studios> studios);
        void onStudiosFilterSuccess(ArrayList<Studios> studios);
    }

    interface Presenter{
        void getStudios();
        void getStudiosFilter(LatLng latLng);
    }
}
