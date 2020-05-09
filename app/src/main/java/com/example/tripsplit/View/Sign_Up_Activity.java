package com.example.tripsplit.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tripsplit.MainActivity;
import com.example.tripsplit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up_Activity extends AppCompatActivity {
    Button mRegister;
    EditText mUsername, mPassword, mEmail;
    ProgressBar mProgressbar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        mRegister = findViewById(R.id.buttonRegister);
        mUsername = findViewById(R.id.enterUsername);
        mPassword = findViewById(R.id.enterPassword);
        mProgressbar = findViewById(R.id.progressBar);
        mEmail = findViewById(R.id.enterEmail);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() == null){//is there no logged in or existing user
            mRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String usernme = mUsername.getText().toString().trim();
                    String passwrd = mPassword.getText().toString().trim();
                    String email = mEmail.getText().toString();

                    if (TextUtils.isEmpty(email)){
                        mEmail.setError("Email Address is a required field");
                        return;
                    }
                    if (TextUtils.isEmpty(usernme)){
                        mUsername.setError("Username is a required field");
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
                    mProgressbar.setVisibility(View.VISIBLE);

                    //here is the actual registration part
                    fAuth.createUserWithEmailAndPassword(email,passwrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Sign_Up_Activity.this,"Account Created",Toast.LENGTH_SHORT).show();

                                FirebaseAuth.getInstance().signOut();//user will have to sign in when they return to other page
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }else{
                                //Toast.makeText(Sign_Up_Activity.this,"ahhhh",Toast.LENGTH_SHORT).show();
                                Toast.makeText(Sign_Up_Activity.this,"Error: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            });

        }else{
            //the user already exists
            Toast.makeText(Sign_Up_Activity.this,"User already exists",Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
