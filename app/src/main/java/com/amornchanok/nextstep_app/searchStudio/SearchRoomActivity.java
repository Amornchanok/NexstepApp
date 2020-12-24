package com.amornchanok.nextstep_app.searchStudio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amornchanok.nextstep_app.R;
import com.amornchanok.nextstep_app.studioHome.StudioHomeAdapter;
import com.amornchanok.nextstep_app.base.BaseActivity;
import com.amornchanok.nextstep_app.map.MapsActivity;
import com.amornchanok.nextstep_app.model.Location;
import com.amornchanok.nextstep_app.model.Studios;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchRoomActivity extends BaseActivity implements SearchRoom.View {
    private Button btSearch,btnLoction,btnDate,btnTime;
    private EditText edtPersons;
    private RecyclerView rvSearchRoom;
    private SearchRoomPresenter presenter;
    private static RecyclerView.Adapter adapter;

    private Location selectLocation = new  Location(new LatLng(0.0,0.0),"");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_practice_room);

        initPresenter();
        initViewData();
        initControl();

    }

    @Override
    public void initControl() {
        btnLoction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationpicker();
            }
        });
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchroomList();
            }
        });
    }

    @Override
    public void initPresenter() {
        presenter = new SearchRoomPresenter(this,this);
        presenter.getStudios();
    }

    @Override
    public void initViewData() {

        btSearch = findViewById(R.id.btSearch);
        btnLoction = findViewById(R.id.btnLoction);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        edtPersons = findViewById(R.id.edtPersons);
        rvSearchRoom = findViewById(R.id.rvSearchRoom);
    }

    public void openSearchroomList() {
        presenter.getStudiosFilter(selectLocation.getLatLng());
//        Intent intent = new Intent(SearchRoomActivity.this, StudioHomeActivity.class);
//        startActivity(intent);
    }

    private int CODE_MAPS = 1000;
    public void openLocationpicker() {
        Intent intent = new Intent(SearchRoomActivity.this, MapsActivity.class);
        startActivityForResult(intent,CODE_MAPS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK) {
            if (requestCode == CODE_MAPS) {
                LatLng latlang =  new LatLng(
                        data.getDoubleExtra("lat",0.0),
                        data.getDoubleExtra("lng",0.0));
                selectLocation.setLatLng(latlang);
                selectLocation.setAddress(data.getStringExtra("address"));

                btnLoction.setText(selectLocation.getAddress());

            }
        }
    }

    @Override
    public void onStudiosSuccess(ArrayList<Studios> studios) {
        rvSearchRoom.setHasFixedSize(true);
        rvSearchRoom.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL ,false));
        rvSearchRoom.setItemAnimator(new DefaultItemAnimator());
        adapter = new StudioHomeAdapter(studios);
//        adapter = new StudioHomeAdapter(studios, (ValueEventListener) this);
        rvSearchRoom.setAdapter(adapter);
    }

    @Override
    public void onStudiosFilterSuccess(ArrayList<Studios> studios) {
        Context mContext = null;
        adapter = new StudioHomeAdapter(studios);
//        adapter = new StudioHomeAdapter(studios, (ValueEventListener) this);
        rvSearchRoom.setAdapter(adapter);
    }
}
