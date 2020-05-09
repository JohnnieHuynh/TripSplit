package com.example.tripsplit.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tripsplit.Controller.tripListAdapter;
import com.example.tripsplit.MainActivity;
import com.example.tripsplit.Model.ItemModel;
import com.example.tripsplit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Trip_List_Activity extends AppCompatActivity {

    //Import Firebase INSTANCE
    private DatabaseReference firebaseINSTANCE;

    //Create RecyclerView for Trip List
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;

    //Create list for itemModel
    List<ItemModel> listItems;

    //Create Toolbar/Appbar
    Toolbar tripAppbar;

    //Put Items into Appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.trip_menu, menu);
        return true;
    }

    //Makes menu items clickable
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            //Back Button
            case R.id.itemBackButt:
                Intent intentTripToLogin = new Intent(Trip_List_Activity.this, Sign_In_Activity.class);
                startActivity(intentTripToLogin);
                return true;

            //Add Button (Currently takes to main page until trip_add act has been created)
            case R.id.itemAddTrip:
                Intent intentTripToAdd = new Intent(Trip_List_Activity.this, NewTripActivity.class);
                startActivity(intentTripToAdd);
                return true;

            //PLACEHOLDER MENU ITEM #1

            //Sign Out Button
            case R.id.itemSignOut:
                Intent intentTripToMainAct = new Intent(Trip_List_Activity.this, MainActivity.class);
                startActivity(intentTripToMainAct);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip__list_);

        //Connect Toolbar / Appbar
        tripAppbar = findViewById(R.id.tripAct_toolbar);
        setSupportActionBar(tripAppbar);

        //Connect RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);

        //Set fixed size for items
        recyclerView.setHasFixedSize(true);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize lists
        listItems = new ArrayList<>();

        //Testing Firebase Grab & Insert into List of Items

        firebaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1");
        firebaseINSTANCE.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot tempSnapshot : dataSnapshot.getChildren()){

                    String tempTN = tempSnapshot.child("tripName").getValue().toString();
                    String tempTD = tempSnapshot.child("tripDesc").getValue().toString();
                    String tempTNum = tempSnapshot.child("tripNum").getValue().toString();
                    String tempTC = tempSnapshot.getKey();

                    listItems.add(new ItemModel (tempTN, tempTD, tempTNum, tempTC));
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
        recAdapter = new tripListAdapter(listItems, this);

        //Set Adapter to Recycler View
        recyclerView.setAdapter(recAdapter);

    }

}
