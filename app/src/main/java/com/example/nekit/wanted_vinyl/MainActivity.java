package com.example.nekit.wanted_vinyl;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    Map<String, LatLng> places = new Place();
    private SearchView loc;
    private SupportMapFragment mapFragment;
    private Gson gson = new GsonBuilder().create();
    private final String server = "https://www.google.com/";
    private Retrofit wantedvinyl = new Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(server)
            .build();

    private Finding find = wantedvinyl.create(Finding.class);

    private static final double MARK_LATITUDE = 55.75222;
    private static final double MARK_LONGTITUDE = 37.61556;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loc = findViewById(R.id.location);
        checkMap();
        createMapView();
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        loc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                    String locationOfMyPrecious = loc.getQuery().toString();
                    List<Address> addresses = null;
                    if(locationOfMyPrecious!= null || !locationOfMyPrecious.equals("")){
                        Geocoder geocoder = new Geocoder(MainActivity.this);
                        try{
                            addresses = geocoder.getFromLocationName(locationOfMyPrecious, 1);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                        Address COME_AND_FIND_IT = addresses.get(0);
                        LatLng latLng = new LatLng(COME_AND_FIND_IT.getLatitude(), COME_AND_FIND_IT.getLongitude());
                        gMap.addMarker(new MarkerOptions().position(latLng).title(locationOfMyPrecious));
                        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
                    }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);
    }

    private boolean checkMap(){
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if(result!=ConnectionResult.SUCCESS){
            if(googleAPI.isUserResolvableError(result)){
                googleAPI.getErrorDialog(this,result,0).show();
            }
            return false;
        }
        return true;
    }


    private void createMapView(){
        try{
            if(null == gMap){
                ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMapAsync((OnMapReadyCallback) this);
                if(null == gMap)
                    Toast.makeText(getApplicationContext(), "Error creating map", Toast.LENGTH_SHORT).show();
            }
        }catch(NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        double lat = MARK_LATITUDE;
        double lng = MARK_LONGTITUDE;
        LatLng moscow = new LatLng(lat, lng);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(moscow).zoom(10).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        gMap.animateCamera(cameraUpdate);
    }
}
