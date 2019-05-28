package com.example.sahil.sahilmahajan_assignment5;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.sahil.sahilmahajan_assignment5.custom.CustomInfoWindowGoogleMap;
import com.example.sahil.sahilmahajan_assignment5.custom.InfoWindowData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    int zoom = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Bundle extras = getIntent().getExtras();
        double lat, lng;
        lat = Double.parseDouble(extras.getString("lat"));
        lng = Double.parseDouble(extras.getString("lng"));
        // Add a marker in Sydney and move the camera
        LatLng restaurant = new LatLng(lat, lng);
        // mMap.addMarker(new MarkerOptions().position(restaurant).title("Marker in Toronto"));
        String title = "RoadSport Showroom \n 941 Progress Avenue \n Toronto, Canada \n Phone: 6479726525";
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
        // Move the camera instantly to toronto with a zoom of 15.
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(restaurant)
                .title(title)
                .snippet(title)
                .icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_RED));

        InfoWindowData info = new InfoWindowData();
        /*info.setHotel("Hotel : excellent hotels available");
        info.setFood("Food : all types of restaurants available");
        info.setTransport("Reach the site by bus, car and train.");*/
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);

        Marker m = mMap.addMarker(markerOptions);
        m.setTag(info);
        m.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, zoom));
    }


    public void ZoomInCLick(View view) {

        Bundle extras = getIntent().getExtras();
        double lat, lng;
        lat = Double.parseDouble(extras.getString("lat"));
        lng = Double.parseDouble(extras.getString("lng"));
        // Add a marker in Sydney and move the camera
        LatLng restaurant = new LatLng(lat, lng);
        zoom++;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, zoom));
    }

    public void ZoomOutCLick(View view) {
        Bundle extras = getIntent().getExtras();
        double lat, lng;
        lat = Double.parseDouble(extras.getString("lat"));
        lng = Double.parseDouble(extras.getString("lng"));
        // Add a marker in Sydney and move the camera
        LatLng restaurant = new LatLng(lat, lng);
        zoom--;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, zoom));
    }

}
