package com.movile.quickbuck.queueapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class GridShowAdapter extends FragmentPagerAdapter {

    public static final int POSITION_FIRST_CONTENT = 0;
    public static final int POSITION_SECOND_CONTENT = 1;
    public static final int POSITION_THIRD_CONTENT = 2;

    private Context mContext;

    public GridShowAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == POSITION_FIRST_CONTENT) {
           return new PlaceListFragment();
        }
        if (position == POSITION_SECOND_CONTENT) {
           return new JoinFragment();
        }
        if (position == POSITION_THIRD_CONTENT) {
           return new StatusFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == POSITION_FIRST_CONTENT) {
            return "Place";
        }
        if (position == POSITION_SECOND_CONTENT) {
            return "Join";
        }
        if (position == POSITION_THIRD_CONTENT) {
            return"Status";
        }
        return null;
    }
}
