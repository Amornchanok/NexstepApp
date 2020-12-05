package com.amornchanok.nextstep_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.partnerRegister.PartnerRegisterProfileActivity;

public class Login extends AppCompatActivity {
    EditText edt_email,edt_password;
    Button bt_regPartner , bt_login;
    boolean valid = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        bt_regPartner = findViewById(R.id.bt_regPartner);
        bt_login = findViewById(R.id.bt_login);

        bt_regPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PartnerRegisterProfileActivity.class));
            }
        });
    }
}
