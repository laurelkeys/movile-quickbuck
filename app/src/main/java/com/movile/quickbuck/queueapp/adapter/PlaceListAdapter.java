package com.movile.quickbuck.queueapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

/**
 * Created by Felipe on 31/10/2015.
 */
public class PlaceListAdapter extends ArrayAdapter<Restaurant> {
    private List<Restaurant> placesList;
    private OnRestaurantClick mClickListener;

    public PlaceListAdapter(Context context, OnRestaurantClick clickListener) {
        super(context, R.layout.restaurant_item);
        mClickListener = clickListener;
    }

    @Override
    public int getCount() {
        return placesList == null ? 0 : placesList.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return placesList == null ? null : placesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.restaurant_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        populateViewFromHolder(holder, position);

        return view;
    }

    private void populateViewFromHolder(ViewHolder holder, final int position) {
        holder.getNumber().setText(placesList.get(position).queue.queueSize.toString()); //numero restaurante
        holder.getTitle().setText(placesList.get(position).name); // nome restaurante
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onRestaurantClick(placesList.get(position));
            }
        });

    }

    public void updateRestaurants(List<Restaurant> restaurants){
        placesList = restaurants;
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        private View mView;
        private TextView number;
        private TextView title;
        public ViewHolder(View root) {
            mView = root;
            number = (TextView) root.findViewById(R.id.restaurant_id);
            title = (TextView) root.findViewById(R.id.restaurant_name);
        }
        public View view() {
            return mView;
        }

        public TextView getNumber(){
            return number;
        }

        public TextView getTitle(){
            return title;
        }
    }
}