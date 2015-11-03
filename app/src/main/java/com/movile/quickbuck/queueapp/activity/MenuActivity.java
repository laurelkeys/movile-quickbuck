package com.movile.quickbuck.queueapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.HashMap;
import java.util.Map;

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
            final Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com/Restaurants");
            Query queryRef = ref.orderByChild("accessCode").equalTo(code.getText().toString());

            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String a = dataSnapshot.getKey();
                    Firebase reff = ref.child(a + "/queue/users");
                    Map<String, String> p = new HashMap<String, String>();
                    p.put("id", "1");
                    p.put("username", "bilada");
                    reff.push().setValue(p);

                    //Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //intent.putExtra(EXTRA_EMAIL, emailUser); ID USUARIO
                    //intent.putExtra(EXTRA_ID, id); USERNAME USUARIO
                    //startActivity(intent);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }
}
