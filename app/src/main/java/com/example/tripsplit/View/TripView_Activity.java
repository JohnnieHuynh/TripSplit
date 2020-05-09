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
import com.example.tripsplit.Controller.tripViewAdapter;
import com.example.tripsplit.MainActivity;
import com.example.tripsplit.Model.ItemModel;
import com.example.tripsplit.Model.UserOpModel;
import com.example.tripsplit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TripView_Activity extends AppCompatActivity {

    //Import Firebase Instance
    private DatabaseReference firebaseINSTANCE;

    //Create RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;

    //Create List for UserOwer Item Models
    List<UserOpModel> listItems;

    //Create Appbar
    Toolbar ViewAppbar;

    //Event ID
    String eventID;
    String eventNum;

    //Put Items into Appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_menu, menu);
        return true;
    }

    //Make Menu Items Clickable
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            //Back Button
            case R.id.itemBackButt:
                Intent intentViewToTripList = new Intent(TripView_Activity.this, Trip_List_Activity.class);
                startActivity(intentViewToTripList);
                return true;

            case R.id.itemAddPerson:
                Intent intentViewToAddPerson = new Intent(TripView_Activity.this, AddPerson_Activity.class);
                intentViewToAddPerson.putExtra("TripID_Extra", eventID);
                intentViewToAddPerson.putExtra("TripNum_Extra", eventNum);
                startActivity(intentViewToAddPerson);
                return true;

            case R.id.itemSignOut:
                Intent intentViewToMain = new Intent(TripView_Activity.this, MainActivity.class);
                startActivity(intentViewToMain);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_view_);


        //Get Extras
        Intent intent = getIntent();
        eventID = intent.getStringExtra("TripID_Extra");
        eventNum = intent.getStringExtra("TripNum_Extra");

        //Connect Appbar
        ViewAppbar = findViewById(R.id.TripView_Toolbar);
        setSupportActionBar(ViewAppbar);

        //Connect RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.TV_RecyclerViewID);

        //Set Fixed Size
        recyclerView.hasFixedSize();

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize lists
        listItems = new ArrayList<>();

        //Insert Firebase Info
        firebaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventGroups").child(eventID);
        firebaseINSTANCE.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String tempSender = snapshot.child("firstname").getValue().toString();
                    String tempOperation = snapshot.child("lastname").getValue().toString();
                    String tempRecipent = "";

                    listItems.add(new UserOpModel(tempSender, tempOperation, tempRecipent));
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
        recAdapter = new tripViewAdapter(listItems, this);

        //Set Adapter to RecyclerView
        recyclerView.setAdapter(recAdapter);
    }
}
