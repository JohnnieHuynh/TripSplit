package com.example.tripsplit.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripsplit.Model.TransactionModel;
import com.example.tripsplit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrans_Activity extends AppCompatActivity {
    private EditText transName;
    private EditText purchaseAmount;
    private EditText date;
    private EditText description;
    String tripID;
    // transaction model
    TransactionModel transaction ;

    //get values


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trans_);
        Button create = findViewById(R.id.newTrans);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                tripID= null;
            } else {
                tripID= extras.getString("TripID_Extra");
            }
        } else {
            tripID= (String) savedInstanceState.getSerializable("TripID_Extra");
        }

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {

        transName = findViewById(R.id.transName);
        purchaseAmount = findViewById(R.id.total);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);

        String name = transName.getText().toString();
        String total= purchaseAmount.getText().toString();
        String dateOf = date.getText().toString();
        String desc = description.getText().toString();
        if (name.isEmpty() || total.isEmpty() || dateOf.isEmpty()|| desc.isEmpty()){
            Toast.makeText(AddTrans_Activity.this, "Not all the required fields are completed. Please complete all.",Toast.LENGTH_LONG).show();
        }else {
            // create new transaction
            transaction = new TransactionModel(name,total,dateOf,desc);

            DatabaseReference databaseINSTANCE = FirebaseDatabase.getInstance().getReference().child("EventPrompts").child("testuser1").child(tripID);
            databaseINSTANCE.push().setValue(transaction).addOnCompleteListener(new OnCompleteListener<Void>() {
                @SuppressLint("ShowToast")
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(AddTrans_Activity.this,"New trip created",Toast.LENGTH_LONG);
                        Intent backToList = new Intent(AddTrans_Activity.this,Trip_List_Activity.class);
                        startActivity(backToList);
                    }else{
                        Toast.makeText(AddTrans_Activity.this,"Error: "+ task.getException().getMessage(),Toast.LENGTH_LONG);
                    }
                }
            });
        }
    }



}
