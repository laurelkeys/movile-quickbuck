package com.movile.quickbuck.queueapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class LoginActivity extends AppCompatActivity {

    public final static String EXTRA_EMAIL = "EXTRA_EMAIL";
    public final static String EXTRA_ID = "EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void cadastrarUsuario(View view){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void logarUsuario(View view) {
        final EditText email = (EditText) findViewById(R.id.email_address);
        EditText password = (EditText) findViewById(R.id.password);
        if (email.getText().toString().equals("") || password.getText().toString().equals(""))
            Toast.makeText(this, "Please fill all the fields correctly", Toast.LENGTH_LONG).show();
        else
        {
            Firebase.setAndroidContext(this);
            Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com");
            ref.authWithPassword(email.getText().toString(), password.getText().toString(), new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    Toast.makeText(getApplicationContext(), "Conectado com sucesso", Toast.LENGTH_LONG).show();
                    String id = authData.getUid();
                    nextPage(id);

                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    Toast.makeText(getApplicationContext(), "Email or password wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void nextPage(String id){
        final EditText email = (EditText) findViewById(R.id.email_address);
        EditText password = (EditText) findViewById(R.id.password);
        Intent intent = new Intent(this, MenuActivity.class);
        String emailUser = email.getText().toString();
        intent.putExtra(EXTRA_EMAIL, emailUser);
        intent.putExtra(EXTRA_ID, id);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
