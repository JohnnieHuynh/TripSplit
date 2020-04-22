package com.example.tripsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tripsplit.View.Sign_In_Activity;
import com.example.tripsplit.View.Sign_Up_Activity;
import com.example.tripsplit.View.Trip_List_Activity;

public class MainActivity extends AppCompatActivity {

    //Buttons for "login" or "create account" screens
    Button loginButt;
    Button signUpButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect Buttons
        loginButt = findViewById(R.id.signInButtID);
        signUpButt = findViewById(R.id.signUpButtID);

        //Send To Login Screen
        loginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainToLogin = new Intent(MainActivity.this, Trip_List_Activity.class);
                startActivity(intentMainToLogin);
            }
        });

        //Send To Sign Up Screen
        signUpButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainToSignUp = new Intent(MainActivity.this, Sign_Up_Activity.class);
                startActivity(intentMainToSignUp);
            }
        });

    }
}
