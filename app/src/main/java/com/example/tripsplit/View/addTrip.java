package com.example.tripsplit.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tripsplit.MainActivity;
import com.example.tripsplit.R;

public class addTrip extends AppCompatActivity {

    Button add;
    Button gobk;

    TextView showT;

    EditText p1;
    EditText p2;
    EditText p3;
    EditText p4;
    EditText p5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        p1 = findViewById(R.id.item1);
        p2 = findViewById(R.id.item2);
        p3 = findViewById(R.id.item3);
        p4 = findViewById(R.id.item4);
        p5 = findViewById(R.id.item5);


        gobk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUp();
            }
        });
    }
    public void addUp(){
        
    }

    public void back(){
        Intent intent = new Intent(addTrip.this, MainActivity.class);
        startActivity(intent);
    }
}
