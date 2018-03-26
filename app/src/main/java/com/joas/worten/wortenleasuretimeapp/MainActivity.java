package com.joas.worten.wortenleasuretimeapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(),MainActivity.this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vpPager);

        vpPager.setAdapter(adapterViewPager);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        final int NUM_ITEMS = 3;
        private final Context context;
        private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };

        public MyPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager);
            this.context =context;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return FirstFragment.newInstance(position, "Page #" + String.valueOf(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }

}

