package com.joas.worten.wortenleasuretimeapp;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Joas on 08-May-18.
 */

/*
public class MyLocationListener implements LocationListener {
    LocationManager locationManager;

    public void onLocationChanged(Location location) {
        // Called when a new location is found by the network location provider
        try {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.i("GPS",location.toString());
        } catch (SecurityException e) {
            Log.e("GPS","ERRROOOOOOOOOO!!!!!!!");
        }
        TextView tvLabel = (TextView) findViewById(R.id.Beep);
        tvLabel.setText(location.toString());
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public void onProviderEnabled(String provider) {}

    public void onProviderDisabled(String provider) {}
};*/

