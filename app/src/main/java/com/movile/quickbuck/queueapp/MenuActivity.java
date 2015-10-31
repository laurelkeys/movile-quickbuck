package com.movile.quickbuck.queueapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

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
}
