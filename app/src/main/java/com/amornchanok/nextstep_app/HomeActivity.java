package com.amornchanok.nextstep_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.searchStudio.SearchRoomActivity;

public class HomeActivity extends AppCompatActivity {
    private Button bt_service1;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.home);

        bt_service1 = (Button) findViewById(R.id.bt_service1);
        bt_service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchroom();
            }
        });
    }
    public void openSearchroom() {
        Intent intent = new Intent(this, SearchRoomActivity.class);
        startActivity(intent);
    }
}


