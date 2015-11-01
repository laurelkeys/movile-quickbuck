package com.movile.quickbuck.queueapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                try {
                    List<Restaurant> restaurants = getRestaurantsFromFirebase(snapshot);

                    printRestaurants(restaurants, mAdapter);
                } catch (Exception e) {
                    Log.e("ERR: ", e.toString());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    private void printRestaurants(final List<Restaurant> restaurants, final PlaceListAdapter mAdapter) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.updateRestaurants(restaurants);
            }
        });
    }

    @NonNull
    private List<Restaurant> getRestaurantsFromFirebase(DataSnapshot snapshot) {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
            Restaurant res = postSnapshot.getValue(Restaurant.class);
            restaurants.add(res);
        }
        return restaurants;
    }

    @Override
    public void onRestaurantClick(Restaurant restaurant) {
        //abrir pagina do restaurante
    }
}
