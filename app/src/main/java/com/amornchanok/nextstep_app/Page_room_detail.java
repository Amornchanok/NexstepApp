package com.amornchanok.nextstep_app;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.amornchanok.nextstep_app.modelStudioList.Order;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Page_room_detail extends AppCompatActivity {
    TextView food_name, food_description, food_price, food_quantity;
    ImageView food_image;
    // CollapsingToolbarLayout collapsingToolbarLayout;
    //FloatingActionButton btnCart;
    //  ElegantNumberButton numberButton;
    private String userid;


    String foodpricestr, foodquantitystr, foodnamestr, foodid, fooddescriptionstr;
    int foodpriceint, foodquantityint;



    Button b_next_1;



    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://nextstepapp-740cf.firebaseio.com/";

    // Declaring String variables to store name & phone number get from EditText.
    String categoryid;
    String s_food_name;
    String s_food_image;

    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "Order";


    ////////////////////////////////////////////////////////
    FirebaseUser firebaseUser;
    String userID;
    TextView text_user_id;
    ////////////////////////////////////////////////////////
    public String currentDate,currenttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_room_detail);
///////////////////////////////////////////////////////////////////////////////////////
        Firebase.setAndroidContext(Page_room_detail.this);
        firebase = new Firebase(Firebase_Server_URL);
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        ///////////////////////////////////////////////////////////
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userID = firebaseUser.getUid();
        /////////////////////////////////////////////////////////


        // btnCart=(FloatingActionButton)findViewById(R.id.btncart);
        food_name = (TextView) findViewById(R.id.food_name);
        food_description = (TextView) findViewById(R.id.food_description);
        food_price = (TextView) findViewById(R.id.food_price);
        food_quantity = (TextView) findViewById(R.id.food_Quantity);

        food_image = (ImageView) findViewById(R.id.img_food);
        //collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        //collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        //collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        categoryid=getIntent().getStringExtra("Category_id");
        foodid=getIntent().getStringExtra("Foodid");
        s_food_image=getIntent().getStringExtra("FoodImage");

        if (getIntent() != null) {
            foodpricestr = getIntent().getStringExtra("FoodPrice");
            foodquantitystr = getIntent().getStringExtra("FoodQuantity");
            fooddescriptionstr = getIntent().getStringExtra("FoodDescribtion");
            food_name.setText("Name: " + getIntent().getStringExtra("FoodName"));
            food_description.setText("Description: " + getIntent().getStringExtra("FoodDescribtion"));
            food_price.setText("Price = " + getIntent().getStringExtra("FoodPrice"));
            food_quantity.setText("Quantity: " + getIntent().getStringExtra("FoodQuantity"));
            Picasso.get().load(getIntent().getStringExtra("FoodImage")).into(food_image);
            //   foodnamestr=food_name.getText().toString();
            //  collapsingToolbarLayout.setTitle(foodnamestr);
        }
        foodpriceint = Integer.parseInt(foodpricestr);
        foodquantityint = Integer.parseInt(foodquantitystr);


        b_next_1 = (Button) findViewById(R.id.b_next_1);
        b_next_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Order data_input = new Order();

                GetDataFromText();

                Calendar calendar = Calendar.getInstance();
                currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                currenttime=format.format(calendar.getTime());
                // String yalhwy=String.valueOf(totalprice);
//



                // Adding name into class function object.
                data_input.setCategory_id(categoryid);
                data_input.setProduct_id(foodid);
                data_input.setProduct_name(s_food_name);
                data_input.setProduct_img(s_food_image);
                data_input.setUser_id(userID);

                data_input.setDate(currentDate);
                data_input.setTime(currenttime);

//
//                foodpricestr = getIntent().getStringExtra("FoodPrice");
//                foodquantitystr = getIntent().getStringExtra("FoodQuantity");
//                fooddescriptionstr = getIntent().getStringExtra("FoodDescribtion");
//                food_name.setText("Name: " + getIntent().getStringExtra("FoodName"));
//                food_description.setText("Description: " + getIntent().getStringExtra("FoodDescribtion"));
//                food_price.setText("Price = " + getIntent().getStringExtra("FoodPrice"));
//                food_quantity.setText("Quantity: " + getIntent().getStringExtra("FoodQuantity"));
//                Picasso.get().load(getIntent().getStringExtra("FoodImage")).into(food_image);


                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(data_input);

                // Showing Toast message after successfully data submit.
                Toast.makeText(Page_room_detail.this, "Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void GetDataFromText() {

        s_food_name = food_name.getText().toString().trim();

        // NumberHolder = editText_number.getText().toString().trim();

    }
}
