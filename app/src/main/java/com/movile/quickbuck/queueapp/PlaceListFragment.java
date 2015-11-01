package com.movile.quickbuck.queueapp;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hp on 31/10/2015.
 */
public class PlaceListFragment extends Fragment implements OnRestaurantClick {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.place_list_fragment, container, false);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();

        ListView view = (ListView) this.getActivity().findViewById(R.id.list_view_restaurants);
        final PlaceListAdapter mAdapter = new PlaceListAdapter(this.getActivity(), this);
        view.setAdapter(mAdapter);

        Firebase.setAndroidContext(this.getContext());
        Firebase ref = new Firebase("https://amber-fire-875.firebaseio.com/Restaurants");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ArrayList<User> lista = new ArrayList<User>();
                lista.add(new User("a", "12"));
                Gson gson = new Gson();
                Queue queue = new Queue(1, lista);
                String a = gson.toJson(queue);
                HashMap<String,ArrayList<Restaurant>> map = gson.fromJson(snapshot.getValue(String.class), new HashMap<String, ArrayList<Restaurant>>().getClass());
                ArrayList<Restaurant> list = map.get("Restaurants");

                mAdapter.updateRestaurants(list);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    @Override
    public void onRestaurantClick(Restaurant restaurant) {
        //abrir pagina do restaurante
    }
}
