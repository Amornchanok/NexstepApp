package com.amornchanok.nextstep_app;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;

public class StudioList extends AppCompatActivity {
    ListView lv;
    FirebaseListAdapter adapter;


//    @Override
//    protected void onCreate (Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.studio_resultlist);
//        lv = (ListView) findViewById(R.id.listview);
//        Query query = FirebaseDatabase.getInstance().getReference().child("Studio");
//        FirebaseListOptions<Studios> options = new FirebaseListOptions.Builder<Studios>.setLayout(R.layout.studio).setQuery(query,Studios.class).build();
//        adapter = new FirebaseListAdapter(options) {
//            @Override
//            protected void populateView(View v, Object model, int position) {
//                TextView stdname = v.findViewById(R.id.stdname);
//                TextView location = v.findViewById(R.id.location);
//                TextView score = v.findViewById(R.id.score);
//
//                Studios std = (Studios) model;
//                stdname.setText(std.getStdname().toString());
//                location.setText(std.getLocation().toString());
//                score.setText(std.getScore().toString());
//
//            }
//        };
//        lv.setAdapter(adapter);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
