package com.amornchanok.nextstep_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {
    EditText edt_firstname,edt_lastname,edt_email,edt_password,edt_phone;
    Button bt_regPartner,bt_login;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partner_reg);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_phone = findViewById(R.id.edt_phone);
        bt_regPartner = findViewById(R.id.bt_regPartner);
        bt_login = findViewById(R.id.bt_login);


        bt_regPartner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(edt_firstname);
                checkField(edt_lastname);
                checkField(edt_email);
                checkField(edt_password);
                checkField(edt_phone);

        if(valid){
            // start user register
            fAuth.createUserWithEmailAndPassword(edt_email.getText().toString(),edt_password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    FirebaseUser user = fAuth.getCurrentUser();
                    Toast.makeText(Register.this,"สร้างบัญชีผู้ใช้",Toast.LENGTH_SHORT).show();
                    DocumentReference df = fStore.collection("Users").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("Firstname",edt_firstname.getText().toString());
                    userinfo.put("Lastname",edt_lastname.getText().toString());
                    userinfo.put("UserEmail",edt_email.getText().toString());
                    userinfo.put("PhoneNumber",edt_phone.getText().toString());

                    userinfo.put("isPartner","1");
                    df.set(userinfo);

                    startActivity(new Intent(getApplicationContext(),RegisterPartner01.class));
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Register.this, "ไม่สามารถสร้างบัญชีได้", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }

    public boolean checkField(EditText textField) { {
            if (textField.getText().toString().isEmpty()){
                textField.setError("Error");
                valid = false;
            }else{
                valid = true;
            }
        }
        return valid;
    }
}
