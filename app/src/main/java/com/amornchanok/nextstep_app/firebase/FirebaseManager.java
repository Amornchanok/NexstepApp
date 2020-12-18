package com.amornchanok.nextstep_app.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CountDownLatch;

public class FirebaseManager {

    private DatabaseReference firebaseRef;

    public FirebaseManager() {
        firebaseRef= FirebaseDatabase.getInstance().getReference();
    }

    public synchronized void getStudios(final FirebaseCallBacks listener) {
        listener.onLoading();
        firebaseRef.child("Studios").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        listener.onSuccess(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        listener.onFailure();
                    }
                }
        );
    }
}
