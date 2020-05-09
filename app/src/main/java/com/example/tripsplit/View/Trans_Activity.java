package com.example.tripsplit.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tripsplit.Controller.TransAdapter;
import com.example.tripsplit.Controller.tripViewAdapter;
import com.example.tripsplit.Model.TransModel;
import com.example.tripsplit.Model.UserOpModel;
import com.example.tripsplit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trans_Activity extends AppCompatActivity {

    //Import Firebase Instance
    private DatabaseReference firebaseINSTANCE;

    //Create RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;

    //Create List for UserOwer Item Models
    List<TransModel> listItems;

    //Event ID
    String eventID;
    String eventNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_);

        //Get Extras
        Intent intent = getIntent();
        eventID = intent.getStringExtra("TripID_Extra");

        //Connect RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.TV_RecyclerViewID);

        //Set Fixed Size
        recyclerView.hasFixedSize();

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize lists
        listItems = new ArrayList<>();

        //Insert Firebase Info
        firebaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1").child(eventID);
        firebaseINSTANCE.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String tempDate = snapshot.child("date").getValue().toString();
                    String tempAmount = snapshot.child("amount").getValue().toString();
                    String tempDesc = snapshot.child("description").getValue().toString();
                    String tempPersonLink = snapshot.child("name").getValue().toString();

                    listItems.add(new TransModel(tempDate, tempAmount, tempDesc, tempPersonLink));
                }

                //Data has changed
                recAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Error Cancelled");
            }
        });

        //Specify Adapter
        recAdapter = new TransAdapter(listItems, this);

        //Set Adapter to RecyclerView
        recyclerView.setAdapter(recAdapter);
    }
}
