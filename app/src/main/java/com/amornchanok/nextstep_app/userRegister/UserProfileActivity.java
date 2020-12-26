package com.amornchanok.nextstep_app.userRegister;

import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.BookingActivity;
import com.amornchanok.nextstep_app.HomeActivity;
import com.amornchanok.nextstep_app.NotiActivity;
import com.amornchanok.nextstep_app.R;
import com.firebase.ui.auth.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class UserProfileActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView textViewEmail;
    Button editProfile;
    TextView textViewName;
    TextView textViewPhone;
    TextView textViewDOB;
    DatabaseReference databaseReference;

    ////////////////////////////////////////////////////////
    FirebaseUser firebaseUser;
    String userID;
    TextView text_user_id;
    ////////////////////////////////////////////////////////

    TextView text_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        BottomNavigationView bottomBar = findViewById(R.id.bottomBar);

        bottomBar.setSelectedItemId(R.id.profile);

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.myBooking:
                        startActivity(new Intent(getApplicationContext(), BookingActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.noti:
                        startActivity(new Intent(getApplicationContext(), NotiActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });


        Button b_action_1 = (Button) findViewById(R.id.b_action_1);
        b_action_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                // Logout();

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserProfileActivity.this, HomeActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
                startActivity(intent);
            }


        });


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userID = firebaseUser.getUid();
        text_user_id = (TextView) findViewById(R.id.text_user_id);
        text_user_id.setText("" + userID);


    }
}