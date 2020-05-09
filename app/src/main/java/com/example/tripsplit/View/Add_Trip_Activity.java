package com.example.tripsplit.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripsplit.Model.TripModel;
import com.example.tripsplit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Trip_Activity extends AppCompatActivity {

    //Enter Text Fields
    EditText textName;
    EditText textDesc;

    //Button
    Button submitButt;

    //Trip Model
    TripModel trip;

    //Datbase Reference to Firebase
    DatabaseReference databaseINSTANCE;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__trip_);

        //Connect EditTexts
        textName = (EditText) findViewById(R.id.editText_TripName);
        textDesc = (EditText) findViewById(R.id.editText_TripDesc);

        //Connect Buttons
        submitButt = (Button) findViewById(R.id.createButton);

        //Refer to Firebase
        /*
        changeble ver
         */
        //databaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1");
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() == null) {
            Toast.makeText(this, "Against all odds, a user magically dissapeared....pt2", Toast.LENGTH_SHORT).show();
        }
        databaseINSTANCE=FirebaseDatabase.getInstance().getReference().child("EventPrompts").child(fAuth.getCurrentUser().getUid());
        //Create Button Clicked
        submitButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempName = textName.getText().toString();
                String tempDesc = textDesc.getText().toString();
                String tempNum = "0";

                trip = new TripModel(tempName, tempDesc, tempNum);

                //Push to Firebase
                databaseINSTANCE.push().setValue(trip);

                //Print Message Pop up
                Toast toast;
                toast = Toast.makeText(getApplicationContext(), "Event Added!" , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

                //Send back to Trip List
                Intent intentAddToTrip = new Intent(Add_Trip_Activity.this, Trip_List_Activity.class);
                startActivity(intentAddToTrip);
            }
        });


    }
}
