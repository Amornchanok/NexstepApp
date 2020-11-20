package com.amornchanok.nextstep_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class ConditionPartner extends AppCompatActivity {
    CheckBox checked_partner;
    Button bt_pnstart;

    @Override
    protected void onCreate (Bundle savedInstanceStated) {
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.partner_condition);

        checked_partner = findViewById(R.id.checked_partner);
        bt_pnstart = findViewById(R.id.bt_pnstart);

        checked_partner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bt_pnstart.setVisibility(View.VISIBLE);
                }else {
                    bt_pnstart.setVisibility(View.INVISIBLE);
                }
            }
        });

        bt_pnstart = findViewById(R.id.bt_pnstart);
        bt_pnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPartnerRegister();
            }
        });
    }
    public void openPartnerRegister() {
        Intent intentReg = new Intent(this, Register.class);
        startActivity(intentReg);
    }
}
