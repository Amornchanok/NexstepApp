package com.amornchanok.nextstep_app.searchStudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.R;
import com.amornchanok.nextstep_app.searchStudio.SearchRoomActivity;
import com.amornchanok.nextstep_app.userRegister.UserProfileActivity;
import com.amornchanok.nextstep_app.userRegister.UserRegisterActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Detail extends AppCompatActivity {

    TextView text_1;
    public static String INTENT_STUDIO_ID = "studioId";
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.detail);

        text_1 = (TextView) findViewById(R.id.text_1);



        Intent intent = getIntent();
        //String s_id = intent.getStringExtra("id");
        String s_id = intent.getStringExtra(INTENT_STUDIO_ID);


        text_1.setText(""+s_id);
    }
}
