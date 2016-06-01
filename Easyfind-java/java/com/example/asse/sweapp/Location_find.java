package com.example.asse.sweapp;


import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;

public class Location_find extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static final String TAG = Location_find.class.getSimpleName();

    TextView locationLabel;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpMapIfNeeded();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

      /*  SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.locate);
        mapFragment.getMapAsync(this);
*/

        locationLabel = (TextView)findViewById(R.id.tv1);
        locationLabel.setText("hi");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object

        mLocationRequest = LocationRequest.create()

                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)

                .setInterval(10 * 1000)        // 10 seconds, in milliseconds

                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

    }

    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }

    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    private void setUpMapIfNeeded() {


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {

       mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }


    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        LatLng kaist_clinic = new LatLng(36.369476, 127.369738);
        String msg = "Current Location: " + latLng;

        // Display the current location in the UI
        //locationLabel.setText(msg);
        //double kaist_clinic_myloc = distancebe
        if (distance(currentLatitude, currentLongitude, 36.369476, 127.369738) > 0.1) { // if distance < 0.1 miles we take locations as equal
            Toast.makeText(getApplicationContext(), "not the same", Toast.LENGTH_LONG).show();
        }
        /*
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("I am here!");
        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    */

    }
    // distance method to compute the

    private double distance(double lat1, double lng1, double lat2, double lng2) {

        double earthRadius = 3958.75; // in miles, change to 6371 for kilometer output

        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);

        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);

        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double dist = earthRadius * c;

        return dist; // output distance, in MILES
    }

    @Override
    public void onConnected(Bundle bundle) {
        // later i will try to remove this if statement

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

       Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        //Log.i(TAG, "Location services connected.");
        
        if (location == null) {
          LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        else {
            handleNewLocation(location);
        }
        

    }

    @Override
    public void onConnectionSuspended(int i) {

        Log.i(TAG, "Location services suspended. Please reconnect.");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }

    }

    @Override
    public void onLocationChanged(Location location) {

        handleNewLocation(location);

    }
}

