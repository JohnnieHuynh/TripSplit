package com.example.tripsplit.View;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripsplit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

@SuppressLint("Registered")
public class NewTripActivity extends AppCompatActivity {
    private EditText tripName;
    private EditText amount;
    private EditText description;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_trip_activity);

        Button create = findViewById(R.id.newTripButton);
        tripName = findViewById(R.id.tripName);
        amount = findViewById(R.id.amountPeople);
        description = findViewById(R.id.tripDescription);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               validate();
            }
        });

    }

    private void validate() {

        String name = tripName.getText().toString();
        String descript = description.getText().toString();
        String people = amount.getText().toString();

        if (name.isEmpty() || descript.isEmpty() || people.isEmpty()){
            Toast.makeText(NewTripActivity.this, "Not all the required fields are completed. Please complete all.",Toast.LENGTH_LONG).show();
        }else {
            addingTrip();
        }

    }

    private void addingTrip() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();


        String name = tripName.getText().toString();
        String descript = description.getText().toString();
        String people = amount.getText().toString();



        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("trip");
        String tripId = ref.push().getKey();
        HashMap<String, String> map = new HashMap<>();
        map.put("tripId",tripId);
        map.put("tripName", name);
        map.put("description",descript);
        map.put("amountPoeple",people);
        // for testing i put liam
        // will change to FirebaseAuth.getInstance().getCurrentUser().getUid()
        // get current user
        String user = "UbUSAIh0yjaVp2eJQ5itQ6xaTb23";

        map.put("userID", user);

        ref.child(tripId).setValue(map);


    }

}
