package com.movile.quickbuck.queueapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by hp on 31/10/2015.
 */
public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        ViewPager pager = (ViewPager) findViewById(R.id.shows_view_pager);
        pager.setAdapter(new GridShowAdapter(this.getSupportFragmentManager(), this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.shows_tab);
        tabLayout.setupWithViewPager(pager);
    }

    public void enviarCode(View view) {
        final EditText code = (EditText) findViewById(R.id.place_code);
        if(code.getText().toString().equals(""))
        {
            Toast.makeText(this, "The field is null", Toast.LENGTH_LONG).show();
        }
        else {
            Firebase.setAndroidContext(this);
            Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com");
            //validar o codigo, colocar na fila e mostrar situacao
        }
    }
}
