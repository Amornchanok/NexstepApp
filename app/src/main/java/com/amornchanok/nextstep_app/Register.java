package com.amornchanok.nextstep_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class Register extends AppCompatActivity {
    EditText edt_firstname,edt_lastname,edt_email,edt_password,edt_phone;
    Button bt_regPartner;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partner_reg);

        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_phone = findViewById(R.id.edt_phone);

        checkField(edt_firstname);
        checkField(edt_lastname);
        checkField(edt_email);
        checkField(edt_password);
        checkField(edt_phone);

        if(valid){
            // start user register
        }

    }

    public boolean checkField(EditText textField) {
        if (textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }
        return valid;
    }
}
