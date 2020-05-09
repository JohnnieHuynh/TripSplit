package com.example.tripsplit.View;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tripsplit.Model.TripModel;
import com.example.tripsplit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

@SuppressLint("Registered")
public class NewTripActivity extends AppCompatActivity {
    private EditText tripName;

    private EditText description;

    //Trip Model
    TripModel trip;

    ProgressDialog pd;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_trip_activity);

        Button create = findViewById(R.id.newTripButton);
        tripName = findViewById(R.id.tripName);

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
        String people = "0";

        if (name.isEmpty() || descript.isEmpty() || people.isEmpty()){
            Toast.makeText(NewTripActivity.this, "Not all the required fields are completed. Please complete all.",Toast.LENGTH_LONG).show();
        }else {
            addingTrip();
        }

    }

    private void addingTrip() {

        pd = new ProgressDialog(NewTripActivity.this);
        pd.setMessage("Uploading");
        pd.show();


        String name = tripName.getText().toString();
        String descript = description.getText().toString();
        String people = "0";
        trip = new TripModel(name, descript, people);

        //Datbase Reference to Firebase
        DatabaseReference databaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1");

        //Push to Firebase
        databaseINSTANCE.push().setValue(trip).addOnCompleteListener(new OnCompleteListener<Void>() {
            @SuppressLint("ShowToast")
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(NewTripActivity.this,"New trip created",Toast.LENGTH_LONG);
                    Intent backToList = new Intent(NewTripActivity.this,Trip_List_Activity.class);
                    startActivity(backToList);
                }else{
                    Toast.makeText(NewTripActivity.this,"Error: "+ task.getException().getMessage(),Toast.LENGTH_LONG);
                }
            }
        });
        pd.dismiss();
    }

}
