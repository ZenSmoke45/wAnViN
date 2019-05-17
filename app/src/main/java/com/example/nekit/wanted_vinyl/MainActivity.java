package com.example.nekit.wanted_vinyl;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap gMap;
    final Place places = new Place();
    private TextView tvWAYLF;
    private EditText etFind;
    private Button btFindThat;

    private String a, answerHTTP;

    private Gson gson = new GsonBuilder().create();
    private final String server = "https://www.google.com/";
    private Retrofit wantedvinyl = new Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(server)
            .build();

    private Finding find = wantedvinyl.create(Finding.class);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btFindThat = (Button) findViewById(R.id.FindThat);
        etFind = (EditText) findViewById(R.id.Find);
        tvWAYLF = (TextView) findViewById(R.id.WAYLF);
        Check();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btFindThat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                a = tvWAYLF.getText().toString();

                Call<String> call = find.performPostCall(places);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) throws NullPointerException{
                        Map<String, LatLng> map = gson.fromJson(response.body().toString(), TreeMap.class);
                        answerHTTP = LatLng.NULL;
                        tvWAYLF.setText(answerHTTP);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        tvWAYLF.setText("ERROR");
                    }
                });
                new Loading().execute();
                onMapReady(gMap);
            }
        });

    }


    private boolean Check(){
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

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    private class Loading extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }
        protected String doInBackground(String... params) {
            try{
                if(null == gMap){
                    ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMapAsync((OnMapReadyCallback) this);
                    if(null == gMap)
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }catch(Exception exception){
                Log.e("mapApp", exception.toString());
            }
            return null;
        }

        protected void onPostExecute(String s) {
            MarkerOptions[] markers = new MarkerOptions[places.size()];
            for(int i = 0; i<places.size(); i++){
                markers[i] = new MarkerOptions().position(places.get(i));
                gMap.addMarker(markers[i]);

            }
            tvWAYLF.setText("We found it");
        }
    }
}
