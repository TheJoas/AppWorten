package com.joas.worten.wortenleasuretimeapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity{

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), MainActivity.this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vpPager);

        vpPager.setAdapter(adapterViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_person);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        final int NUM_ITEMS = 3;
        private final Context context;

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
            switch (position){
                case 0: return FirstFragment.newInstance(position, "Page #" + String.valueOf(position));
                case 1: return SecondFragment.newInstance();
                case 2: return FirstFragment.newInstance(position, "Page #" + String.valueOf(position));
                default: return FirstFragment.newInstance(position, "Page #" + String.valueOf(position));
            }
        }
    }

}

