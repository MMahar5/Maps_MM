package com.example.maps_mm;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MapStyleOptions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    //Declare variables
    private Button activateLocationBtn;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private TextView locationTextView;




    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), intent -> {
                if (locationPermissionEnabled()) {

                    activateLocationBtn.setVisibility(View.GONE);


                }

            });


    //Method for starting the gps and logging the location
    @SuppressLint("MissingPermission")
    private void startGPS(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        fusedLocationProviderClient.requestLocationUpdates(
                locationRequest,
                new LocationCallback() {

                    @Override
                    public void onLocationResult(@NonNull LocationResult locationResult) {
                        super.onLocationResult(locationResult);

                        double  latitude = locationResult.getLastLocation().getLatitude(),
                                longitude = locationResult.getLastLocation().getLongitude();

                        //Shows location in log
                        Log.e("LOCATION", "Lat: " + latitude + ", lon: " + longitude);

                        //Sets the textview to show location
                        locationTextView.setText("Lat: " + latitude + ", Lon: " + longitude);


                    }
                },
                Looper.getMainLooper()
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);

        mapFragment.getMapAsync(this);

        activateLocationBtn = findViewById(R.id.activateLocationBtn);
        locationTextView = findViewById(R.id.locTextView);

        activateLocationBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        activityResultLauncher.launch(intent);
                    }
                }
        );

        //Checks for location permission and hides button if it is
        if(locationPermissionEnabled()) {
            startGPS();
            activateLocationBtn.setVisibility(View.GONE);
        }

    }


    //Method to check if location permission is enabled
    private boolean locationPermissionEnabled(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        //Sets the map style to the custom theme from raw folder (retro map theme)
        googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(this, R.raw.retro_map_theme)
        );

    }
}