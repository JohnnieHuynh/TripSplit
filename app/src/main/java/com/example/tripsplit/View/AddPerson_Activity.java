package com.example.tripsplit.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripsplit.Model.PersonModel;
import com.example.tripsplit.Model.UserOpModel;
import com.example.tripsplit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddPerson_Activity extends AppCompatActivity {

    //Text Fields for user input
    EditText textFN;
    EditText textLN;

    //Create Button
    Button createButt;

    //Create Appbar
    Toolbar AddPersonAppbar;

    //Model for one Person
    PersonModel personObj;

    //Firebase
    DatabaseReference firebaseINSTANCE;
    DatabaseReference firebaseINSTANCE_EditAmount;
    DatabaseReference FB_UserAmount_Test;

    //Event ID
    String eventID;
    String eventNum;

    //Temp Values
    String tempStrNum;
    int tempInt;
    String editedStrAmount;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_person_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemBackButtADM:
                Intent intentAddPersToTripView = new Intent(AddPerson_Activity.this, TripView_Activity.class);
                intentAddPersToTripView.putExtra("TripID_Extra", eventID);
                startActivity(intentAddPersToTripView);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person_);

        //Get Extras
        Intent intent = getIntent();
        eventID = intent.getStringExtra("TripID_Extra");
        //eventNum = intent.getStringExtra("TripNum_Extra");

        //Connect Appbar
        AddPersonAppbar = (Toolbar) findViewById(R.id.AddPerson_toolbar);
        setSupportActionBar(AddPersonAppbar);

        //Connect TextFields
        textFN = (EditText) findViewById(R.id.editText_FN);
        textLN = (EditText) findViewById(R.id.editText_LN);

        //Connect Buttons
        createButt = (Button) findViewById(R.id.button_submit_addP);

        //Firebase Reference
        firebaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventGroups").child(eventID);
        firebaseINSTANCE_EditAmount = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1");

        //Create Button Clicked
        createButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Input from Text Fields
                String tempFN = textFN.getText().toString();
                String tempLN = textLN.getText().toString();

                //Create New Person Model Object
                personObj = new PersonModel(tempFN, tempLN);

                //Replace Str
                tempStrNum = eventNum;


                //Convert STR to Int and Add +1, then convert back to STR
                tempInt = Integer.parseInt(tempStrNum);
                tempInt+=1;
                editedStrAmount = Integer.toString(tempInt);

                //Edit Amount of Users in Event table, in Firebase
                FB_UserAmount_Test = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1").child(eventID).child("tripNum");
                FB_UserAmount_Test.setValue(editedStrAmount);

                //Print Message Pop up
                Toast toast;
                toast = Toast.makeText(getApplicationContext(), "Person Added!" , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

                //Push to Firebase
                firebaseINSTANCE.push().setValue(personObj);

                //Make intent for moving screens
                Intent intent = new Intent(AddPerson_Activity.this, TripView_Activity.class);
                intent.putExtra("TripID_Extra", eventID);
                intent.putExtra("TripNum_Extra", editedStrAmount);
                startActivity(intent);
            }
        });
    }
}
