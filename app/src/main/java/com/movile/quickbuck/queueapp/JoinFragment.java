package com.movile.quickbuck.queueapp;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


/**
 * Created by hp on 31/10/2015.
 */
public class JoinFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.join_fragment, container, false);
    }
    public void enviarCode(View view) {
        final EditText code = (EditText) this.getActivity().findViewById(R.id.place_code);
        if(code.equals(""))
        {
            Toast.makeText(this.getActivity(), "The field is null", Toast.LENGTH_LONG).show();
        }
        Firebase.setAndroidContext(this.getActivity());
        Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com");
        



    }
}
