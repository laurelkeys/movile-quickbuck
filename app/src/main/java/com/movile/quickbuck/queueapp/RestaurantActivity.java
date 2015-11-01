package com.movile.quickbuck.queueapp;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felipe on 01/11/2015.
 */
public class RestaurantActivity extends AppCompatActivity {

    public final static String EXTRA_NAME = "EXTRA_NAME";
    public final static String EXTRA_ADDRESS = "EXTRA_ADDRESS";
    public final static String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public final static String EXTRA_QUEUE = "EXTRA_QUEUE";
    public final static String EXTRA_ACESSCODE = "EXTRA_ACESSCODE";

    public String name, address, description, accesscode; public Integer queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        extractInformationsFromExtra();
        configureTextsViews();
    }

    public void configureTextsViews(){
        TextView nome = (TextView) findViewById(R.id.name_restaurant);
        nome.setText(name);

        TextView addrr = (TextView) findViewById(R.id.address_restaurant);
        addrr.setText(address);

        TextView descrip = (TextView) findViewById(R.id.description_restaurant);
        descrip.setText(description);

        TextView sizeQueue = (TextView) findViewById(R.id.queue_restaurant);
        sizeQueue.setText(queue + "");
    }

    public void entrarFila(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Pagamento");
        alertDialog.setMessage("Hoje é por conta da casa");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
// here you can add functions
            }
        });
        alertDialog.show();

        Firebase.setAndroidContext(this);
        final Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com/Restaurants");
        Query queryRef = ref.orderByChild("name").equalTo(name);

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

    public void extractInformationsFromExtra(){
        Bundle extras = getIntent().getExtras();
        name = extras.getString(PlaceListFragment.EXTRA_NAME);
        description = extras.getString(PlaceListFragment.EXTRA_DESCRIPTION);
        address = extras.getString(PlaceListFragment.EXTRA_ADDRESS);
        queue = extras.getInt(PlaceListFragment.EXTRA_QUEUE);
        accesscode = extras.getString(PlaceListFragment.EXTRA_ACESSCODE);
    }
}
