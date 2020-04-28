package com.example.tripsplit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripsplit.View.Sign_In_Activity;
import com.example.tripsplit.View.Sign_Up_Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {

    //Buttons for "login" or "create account" screens
    Button loginButt;
    Button signUpButt;
    FirebaseAuth fAuth;
    EditText mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect Buttons
        loginButt = findViewById(R.id.signInButtID);
        signUpButt = findViewById(R.id.signUpButtID);
        mEmail = findViewById(R.id.enterEmail2);
        mPassword = findViewById(R.id.enterPassword2);
        fAuth = FirebaseAuth.getInstance();

        //Send To Login Screen
        loginButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                the old has been commented out, no need for another activity
                for logging in
                */
                //Intent intentMainToLogin = new Intent(MainActivity.this, Sign_In_Activity.class);
                //startActivity(intentMainToLogin);

                String passwrd = mPassword.getText().toString().trim();
                String email = mEmail.getText().toString();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email Address is a required field");
                    return;
                }
                if (TextUtils.isEmpty(passwrd)){
                    mPassword.setError("Password is a required field");
                    return;
                }
                if (passwrd.length()<6){//6 is based in firebase i guess
                    mPassword.setError("Password is too short");
                    return;
                }
                //check if user exists before logging them in
                fAuth.signInWithEmailAndPassword(email,passwrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //the user has been logged in
                            Toast.makeText(MainActivity.this, "User logged in successful", Toast.LENGTH_SHORT).show();
                            /*/
                             !!!!!!
                             */
                            //startActivity();//this is where it will go to the screen with the trips n shit
                        }else{
                            //an error occured trying to validate user
                            Toast.makeText(MainActivity.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
