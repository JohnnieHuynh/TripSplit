package com.example.tripsplit.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.tripsplit.Controller.tripListAdapter;
import com.example.tripsplit.Model.ItemModel.ItemModel;
import com.example.tripsplit.R;

import java.util.ArrayList;
import java.util.List;

public class Trip_List_Activity extends AppCompatActivity {


    //Create RecyclerView for Trip List
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;

    //Create list for itemModel
    List<ItemModel> listItems;

    //Create Toolbar/Appbar
    Toolbar tripAppbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.trip_menu, menu);
        return true;
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

        //TESTING by adding sample item to list
        listItems.add(new ItemModel(1, "Disney Land", "7 Weeks", "2", "Tom"));
        listItems.add(new ItemModel(2, "Lil Timmys Birthday", "RoadTrip to Pismo", "6", "Tom"));

        //Specify Adapter
        recAdapter = new tripListAdapter(listItems, this);

        //Set Adapter to Recycler View
        recyclerView.setAdapter(recAdapter);

    }
}






















