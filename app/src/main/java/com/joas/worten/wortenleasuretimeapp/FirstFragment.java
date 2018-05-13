package com.joas.worten.wortenleasuretimeapp;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Joas on 26-Mar-18.
 */

public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private double latitude= 0 , longitude = 0;
    private int permissiongranted;
    ImageButton btn;
    LocationManager locationManager = null;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.Beep);
        tvLabel.setText(page + " -- " + title);

        btn = (ImageButton) view.findViewById(R.id.GPSbutton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LocationListener locationListener = new MyLocationListener();
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},permissiongranted);
                try {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
                }catch (SecurityException e) {
                    Log.e("GPS","YAY!!!!!!!");
                }
            }
        });
        return view;
    }

    private class MyLocationListener implements LocationListener {
        public void onLocationChanged(Location location) {
            // Called when a new location is found by the network location provider
            try {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                longitude = location.getLatitude();
                latitude = location.getLongitude();
                Log.i("GPS",location.toString());
            } catch (SecurityException e) {
                Log.e("GPS","ERRROOOOOOOOOO!!!!!!!");
            }
            TextView tvLabel = (TextView) getActivity().findViewById(R.id.Beep);
            tvLabel.setText("Longitude" + Double.toString(longitude) + "Latitude" + Double.toString(latitude));
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
    };
}


