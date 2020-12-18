package com.amornchanok.nextstep_app.partnerRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.amornchanok.nextstep_app.MyApplication;
import com.amornchanok.nextstep_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class PartnerRegisterProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText edt_firstname,edt_lastname,edt_email,edt_password,edt_phone;
    Spinner spGender;
    Button bt_regPartnerNext,bt_login;
    int i = 0;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_register_profile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_phone = findViewById(R.id.edt_phone);
        bt_regPartnerNext = findViewById(R.id.bt_regPartner_next);
//        bt_login = findViewById(R.id.bt_login);

        spGender = (Spinner) findViewById(R.id.spGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setOnItemSelectedListener(this);


        bt_regPartnerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkField(edt_firstname);
//               checkField(edt_lastname);
//                checkField(edt_email);
//                checkField(edt_password);
//                checkField(edt_phone);

//        if(valid){
//            MyApplication.partner.setFirstname(edt_firstname.getText().toString());
//            MyApplication.partner.setLastname(edt_lastname.getText().toString());
//            MyApplication.partner.setEmail(edt_email.getText().toString());
//            MyApplication.partner.setPassword(edt_password.getText().toString());
//            MyApplication.partner.setPhone(edt_phone.getText().toString());

            startActivity(new Intent(PartnerRegisterProfileActivity.this, PartnerRegisterOtpActivity.class));
            finish();

//            // start user register
//            fAuth.createUserWithEmailAndPassword(edt_email.getText().toString(),edt_password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                @Override
//                public void onSuccess(AuthResult authResult) {
//                    FirebaseUser user = fAuth.getCurrentUser();
//                    Toast.makeText(PartnerRegisterProfileActivity.this,"สร้างบัญชีผู้ใช้",Toast.LENGTH_SHORT).show();
//                    DocumentReference df = fStore.collection("Users").document(user.getUid());
//                    Map<String,Object> userinfo = new HashMap<>();
//                    userinfo.put("Firstname",edt_firstname.getText().toString());
//                    userinfo.put("Lastname",edt_lastname.getText().toString());
//                    userinfo.put("UserEmail",edt_email.getText().toString());
//                    userinfo.put("PhoneNumber",edt_phone.getText().toString());
//
////                    if  (reg_partner.isChecked()) {
////                        userinfo.put("isPartner","1");
////                    }else if (reg_user.isChecked()) {
////                        userinfo.put("isUser", "0");
////                    }
////                    df.set(userinfo);
//
//                    startActivity(new Intent(getApplicationContext(), PartnerRegisterImageActivity.class));
//                    finish();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(PartnerRegisterProfileActivity.this, "ไม่สามารถสร้างบัญชีได้", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }
//            }
        });

//        bt_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Login.class));
//            }
//        });


    }

    public boolean checkField(EditText textField) { {
            if (textField.getText().toString().trim().isEmpty()){
                textField.setError("Error");
                valid = false;
            }else{
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
