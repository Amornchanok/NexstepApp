package com.amornchanok.nextstep_app.userRegister;

import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.HomeActivity;
import com.amornchanok.nextstep_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MenuActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu);


        Button b_action_1 = (Button) findViewById(R.id.b_action_1);
        b_action_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                // Logout();

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, HomeActivity.class);

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