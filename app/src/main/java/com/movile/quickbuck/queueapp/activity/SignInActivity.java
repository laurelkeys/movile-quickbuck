package com.movile.quickbuck.queueapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by Felipe on 31/10/2015.
 */
public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void registerUser(View view){
        final EditText email = (EditText) findViewById(R.id.email_address);
        EditText password = (EditText) findViewById(R.id.password);
        EditText confirmPassword = (EditText) findViewById(R.id.confirm_password);
        if(email.getText().toString().equals("") || password.getText().toString().equals("") || confirmPassword.getText().toString().equals("")
                || !password.getText().toString().equals(confirmPassword.getText().toString()))
            Toast.makeText(this, "Fields were completed incorrectly", Toast.LENGTH_LONG).show();
        else{
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com");
        ref.createUser(email.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                Toast.makeText(getApplicationContext(), "Please fill all the fields correctly", Toast.LENGTH_LONG).show();
        }});
    }}}
